package netmehdi.auctionapp.services;

import netmehdi.auctionapp.entities.Categorie;

import java.util.List;

public interface CategorieServie {
    Categorie getCategorieById(Long id);
    List<Categorie> getAllCategories();
    Categorie addCategorie(Categorie categorie);
    Categorie updateCategorie(Categorie categorie);
    void deleteCategorie(Long id);

}
