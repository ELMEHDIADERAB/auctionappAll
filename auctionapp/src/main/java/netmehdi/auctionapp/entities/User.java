package netmehdi.auctionapp.entities;

import jakarta.persistence.*;
import jakarta.servlet.http.Part;
import lombok.Data;
import netmehdi.auctionapp.enums.Role;


import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;

//    @Enumerated(EnumType.STRING)
//    private Role role; //Admin , Acheteur ou vendeur

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Participation> participationList;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Role_id")
    private RoleUtilisateur role;

}

