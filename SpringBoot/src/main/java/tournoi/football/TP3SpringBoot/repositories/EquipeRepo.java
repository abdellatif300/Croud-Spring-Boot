package tournoi.football.TP3SpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tournoi.football.TP3SpringBoot.entity.Equipe;

import java.util.List;
import java.util.Optional;


@Repository
public interface EquipeRepo extends JpaRepository<Equipe,Long> {
//    Equipe findEquipeById(Long id);
    List<Equipe> findByPays(String pays);

    List<Equipe> findByNomEquipe(String nameequipe);

    List<Equipe> findByMatchesIdMatch(Long id);
}
