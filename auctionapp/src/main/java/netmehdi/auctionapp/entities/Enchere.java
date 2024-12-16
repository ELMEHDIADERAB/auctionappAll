package netmehdi.auctionapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Enchere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
    @OneToMany(mappedBy = "enchere", cascade = CascadeType.ALL)
    private List<Participation> participationList;
    @OneToOne
    private Product product;

    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    private Boolean statut;
    private Boolean actif;
}