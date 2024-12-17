package netmehdi.auctionapp.repositories;


import netmehdi.auctionapp.DTO.EnchereDetailsDTO;
import netmehdi.auctionapp.entities.Enchere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnchereRepository extends JpaRepository<Enchere, Long> {
    @Query("SELECT e.id, e.actif, e.dateDebut, e.dateFin, e.participationList, e.product.categorie.nom as nom, e.product.description, e.product.prixInitiale, e.product.categorie " +
            "FROM Enchere e")
    List<Enchere> findAllEncheres();


//    @Query("SELECT e.id,e.dateFin ,p.montant,pr.nom,pr.description,c.nom FROM Enchere e JOIN e.participationList  p JOIN e.product  pr join pr.categorie  c ")
//    List<Object[]> findEnchereById(@Param("EnchereId")Long EnchereId);
@Query("SELECT  e.id, e.dateFin, p.montant, pr.nom, pr.description, c.nom " +
        "FROM Enchere e " +
        "JOIN e.participationList p " +
        "JOIN e.product pr " +
        "JOIN pr.categorie c " +
        "WHERE e.id = :EnchereId")
        Enchere EnchereById(@Param("EnchereId") Long EnchereId);


}