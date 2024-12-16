package netmehdi.auctionapp.repositories;


import netmehdi.auctionapp.entities.Enchere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnchereRepository extends JpaRepository<Enchere, Long> {
}