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
public class Stade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long idStade ;
    String nomStade ;
    String ville ;
    @OneToMany(mappedBy = "stade")
    @JsonIgnore
    List<Match> matches ;
}