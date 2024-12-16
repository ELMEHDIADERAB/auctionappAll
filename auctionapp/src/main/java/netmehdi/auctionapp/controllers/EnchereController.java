package netmehdi.auctionapp.controllers;


import netmehdi.auctionapp.entities.Enchere;
import netmehdi.auctionapp.services.EnchereServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/encheres")
@CrossOrigin(origins = "http://localhost:3000") // Autorise React.js en local
public class EnchereController {

    private final EnchereServiceImp enchereService;

    public EnchereController(EnchereServiceImp enchereService) {
        this.enchereService = enchereService;
    }

//    @GetMapping("/Encheres")
//    public List<Enchere> getEncheres(){
//        return enchereService.getAllEnchere();
//    }

    @GetMapping("/")
    public ResponseEntity<List<Enchere>> getAllEncheres() {
        return new  ResponseEntity<>(enchereService.getAllEnchere(), HttpStatus.OK);
        //return enchereService.getAllEnchere();
    }

    @GetMapping("/{id}")
    public Optional<Enchere> getEnchereById(@PathVariable Long id) {
        return enchereService.findById(id);
    }

    @PostMapping
    public Enchere createEnchere(@RequestBody Enchere enchere) {
        return enchereService.save(enchere);
    }

    @PutMapping("/{id}/close")
    public void closeEnchere(@PathVariable Long id) {
        enchereService.closeEnchere(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEnchere(@PathVariable Long id) {
        enchereService.deleteById(id);
    }

//    @PostMapping("/{productId}")
//    public Enchere placeEnchere(@PathVariable Long productId, @RequestBody Enchere enchere) {
//        return enchereService.placeEnchere(productId, enchere);
//    }
}