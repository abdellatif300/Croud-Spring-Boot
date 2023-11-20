package tournoi.football.TP3SpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tournoi.football.TP3SpringBoot.entity.Arbitre;

@Repository
public interface ArbitreRepo extends JpaRepository<Arbitre,Long> {
}
