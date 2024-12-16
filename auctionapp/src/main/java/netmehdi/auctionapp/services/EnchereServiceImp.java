package netmehdi.auctionapp.services;


import netmehdi.auctionapp.entities.Enchere;
import netmehdi.auctionapp.entities.Participation;
import netmehdi.auctionapp.repositories.EnchereRepository;
import netmehdi.auctionapp.repositories.ParticipationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnchereServiceImp implements EnchereService{

    private EnchereRepository enchereRepository;
    private ParticipationRepository participationRepository;

    public EnchereServiceImp(EnchereRepository enchereRepository, ParticipationRepository participationRepository) {
        this.enchereRepository = enchereRepository;
        this.participationRepository = participationRepository;
    }

    @Override
    public List<Enchere> getAllEnchere() {
        return enchereRepository.findAll();
    }

    @Override
    public Optional<Enchere> findById(Long id) {
        return enchereRepository.findById(id);
    }

    @Override
    public Enchere save(Enchere enchere) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void closeEnchere(Long enchereId) {
        Optional<Enchere> enchereOpt = enchereRepository.findById(enchereId);
        if (enchereOpt.isPresent()) {
            Enchere enchere = enchereOpt.get();
            if (LocalDateTime.now().isAfter(enchere.getDateFin())) {
                enchere.setStatut(true);
                enchere.setActif(false);
                enchereRepository.save(enchere);

                // Déterminer le gagnant
                List<Participation> participations = participationRepository.findAll()
                        .stream()
                        .filter(p -> p.getEnchere().getId().equals(enchereId))
                        .collect(Collectors.toList());

                if (!participations.isEmpty()) {
                    Participation gagnant = participations.stream()
                            .max(Comparator.comparingDouble(Participation::getMontant))
                            .orElse(null);

                    if (gagnant != null) {
                        System.out.println("L'utilisateur gagnant est : " + gagnant.getUser().getUsername());
                    } else {
                        System.out.println("Aucun gagnant pour cette enchère.");
                    }
                }
            } else {
                throw new IllegalStateException("L'enchère n'est pas encore terminée.");
            }
        } else {
            throw new IllegalArgumentException("Enchère introuvable.");
        }
    }


}