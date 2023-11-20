package tournoi.football.TP3SpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tournoi.football.TP3SpringBoot.entity.Joueur;

import java.util.List;


@Repository
public interface JoueurRepo extends JpaRepository<Joueur,Long> {
    List<Joueur> findByEquipeNomEquipe(String nom);
    List<Joueur> findByEquipeNomEquipeAndPoste(String nom , String post);


}
