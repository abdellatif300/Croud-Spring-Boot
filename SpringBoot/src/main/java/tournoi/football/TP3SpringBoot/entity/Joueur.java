package tournoi.football.TP3SpringBoot.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Joueur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long idJoueur ;
    String nomJoueur ;
    String poste ;
    @ManyToOne
    @JoinColumn(name = "equipe_id")
    Equipe equipe ;
}