package netmehdi.auctionapp.services;

import netmehdi.auctionapp.entities.Participation;

import java.util.List;
import java.util.Optional;

public interface ParticipationService {
//    Participation getParticipation(Long id);
//    Participation createParticipation(Participation participation);
//    Participation updateParticipation(Long id, Participation participation);
//    void deleteParticipation(Long id);
//    List<Participation> getAllParticipations();

    public List<Participation> findAll() ;

     Optional<Participation> findById(Long id);

     Participation save(Participation participation);

     void deleteById(Long id);

}
