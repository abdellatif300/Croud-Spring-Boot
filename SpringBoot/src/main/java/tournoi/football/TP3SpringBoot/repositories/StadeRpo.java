package tournoi.football.TP3SpringBoot.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tournoi.football.TP3SpringBoot.entity.Stade;

import java.util.Optional;

@Repository
public interface StadeRpo extends JpaRepository<Stade,Long> {
    //Stade save(Stade stade);
    //Optional<Stade> updateBy(Long aLong);
}
