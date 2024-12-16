package netmehdi.auctionapp.services;

import netmehdi.auctionapp.entities.Enchere;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface EnchereService {

    List<Enchere> getAllEnchere();
    Optional<Enchere> findById(Long id) ;
    Enchere save(Enchere enchere);
    void deleteById(Long id);
    void closeEnchere(Long enchereId);
}
