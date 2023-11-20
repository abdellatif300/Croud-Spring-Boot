package tournoi.football.TP3SpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tournoi.football.TP3SpringBoot.entity.Match;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface MatchRpo extends JpaRepository<Match,Long> {
  List<Match> findByDateMatch(LocalDate date);
  void deleteByDateMatchLessThan(LocalDate date);
}
