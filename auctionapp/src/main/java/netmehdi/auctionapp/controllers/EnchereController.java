package netmehdi.auctionapp.controllers;


import netmehdi.auctionapp.DTO.EnchereDetailsDTO;
import netmehdi.auctionapp.entities.Enchere;
import netmehdi.auctionapp.services.EnchereServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        List<Enchere> encheres = enchereService.getAllEnchere();
        if (encheres.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // No content found
        }
        return new ResponseEntity<>(encheres, HttpStatus.OK);
       // return new  ResponseEntity<>(enchereService.getAllEnchere(), HttpStatus.OK);
        //return enchereService.getAllEnchere();
    }

   // @GetMapping("/{id}")
   @GetMapping("/{id}")
   public ResponseEntity<List<Object[]>> getEnchereById(@PathVariable("id") Long id) {
        List<Object[]> encheres=enchereService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(encheres);
//       List<Object[]> result = (List<Object[]>) enchereService.findById(id);
//
//       if (result == null) {
//           return ResponseEntity.notFound().build();
//       }
//
//       return ResponseEntity.ok(result);
   }

//    @GetMapping("/{id}")
//    public ResponseEntity<EnchereDetailsDTO> getEnchereById(@PathVariable Long id) {
//        EnchereDetailsDTO enchere = enchereService.findById(id);
//        if (enchere == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(enchere, HttpStatus.OK);
//    }

//    public Optional<Enchere> getEnchereById(@PathVariable Long id) {
//        return enchereService.findById(id);
//    }

    @PostMapping
    public ResponseEntity<Enchere> createEnchere(@RequestBody Enchere enchere) {
        return new  ResponseEntity<>(enchereService.save(enchere),HttpStatus.CREATED);
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