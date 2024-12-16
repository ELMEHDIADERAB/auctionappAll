package netmehdi.auctionapp.controllers;

import netmehdi.auctionapp.entities.Participation;
import netmehdi.auctionapp.services.ParticipationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/participations")
@CrossOrigin(origins = "http://localhost:3000")
public class ParticipationController {

    @Autowired
    private ParticipationService participationService;

    @GetMapping
    public List<Participation> getAllParticipations() {
        return participationService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Participation> getParticipationById(@PathVariable Long id) {
        return participationService.findById(id);
    }

    @PostMapping
    public Participation createParticipation(@RequestBody Participation participation) {
        return participationService.save(participation);
    }

    @DeleteMapping("/{id}")
    public void deleteParticipation(@PathVariable Long id) {
        participationService.deleteById(id);
    }
}