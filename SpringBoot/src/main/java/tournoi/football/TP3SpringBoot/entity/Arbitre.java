package tournoi.football.TP3SpringBoot.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Arbitre {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long idArbitre ;
    String nom ;
    String nationalite ;
    @OneToMany(mappedBy = "arbitre")
    @JsonIgnore
    List<Match> matches ;

}
