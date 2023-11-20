package tournoi.football.TP3SpringBoot.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "`match`")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long idMatch ;
    LocalDate dateMatch ;
    LocalTime heureMatch ;
    @ManyToOne
    @JoinColumn(name = "arbitre_id")
    Arbitre arbitre ;
    @ManyToOne
    @JoinColumn(name = "stade_id")
    Stade stade ;
    @ManyToMany
    @JoinColumn(name = "equipes_id")
    private List<Equipe> equipes;


}
