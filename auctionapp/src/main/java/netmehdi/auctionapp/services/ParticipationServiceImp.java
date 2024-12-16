package netmehdi.auctionapp.services;

import netmehdi.auctionapp.entities.Enchere;
import netmehdi.auctionapp.entities.Participation;
import netmehdi.auctionapp.repositories.EnchereRepository;
import netmehdi.auctionapp.repositories.ParticipationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ParticipationServiceImp implements ParticipationService {
    private ParticipationRepository participationRepository;
    private EnchereRepository enchereRepository;

    public ParticipationServiceImp(ParticipationRepository participationRepository, EnchereRepository enchereRepository) {
        this.participationRepository = participationRepository;
        this.enchereRepository = enchereRepository;
    }

    @Override
    public List<Participation> findAll() {
        return participationRepository.findAll();
    }

    @Override
    public Optional<Participation> findById(Long id) {
        return participationRepository.findById(id);
    }

    @Override
    public Participation save(Participation participation) {
        Optional<Enchere> enchereOpt = enchereRepository.findById(participation.getEnchere().getId());
        if (enchereOpt.isPresent()) {
            Enchere enchere = enchereOpt.get();
            if (!enchere.getActif() || LocalDateTime.now().isAfter(enchere.getDateFin())) {
                throw new IllegalStateException("L'enchère est clôturée ou inactive.");
            }
            return participationRepository.save(participation);
        } else {
            throw new IllegalArgumentException("Enchère introuvable.");
        }
    }

    @Override
    public void deleteById(Long id) {
        participationRepository.deleteById(id);
    }
    //
//    @Override
//    public Participation getParticipation(Long id) {
//        return participationRepository.getById(id);
//    }
//
//    @Override
//    public Participation createParticipation(Participation participation) {
//        return participationRepository.save(participation);
//    }
//
//    @Override
//    public Participation updateParticipation(Long id, Participation participation) {
//        Participation  p = participationRepository.getById(id);
//        return participationRepository.save(p);
//    }
//
//    @Override
//    public void deleteParticipation(Long id) {
//        participationRepository.deleteById(id);
//    }
//
//    @Override
//    public List<Participation> getAllParticipations() {
//        return participationRepository.findAll();
//    }
}
