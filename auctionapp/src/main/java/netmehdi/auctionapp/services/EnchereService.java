package netmehdi.auctionapp.services;

import netmehdi.auctionapp.DTO.EnchereDetailsDTO;
import netmehdi.auctionapp.entities.Enchere;

import java.util.List;
import java.util.Optional;


public interface EnchereService {

    List<Enchere> getAllEnchere();
     List<Object[]> findById(Long id);
    // EnchereDetailsDTO findById(Long id) ;
    Enchere save(Enchere enchere);
    void deleteById(Long id);
    void closeEnchere(Long enchereId);
}
