package tournoi.football.TP3SpringBoot.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import tournoi.football.TP3SpringBoot.entity.Match;
import tournoi.football.TP3SpringBoot.entity.Stade;
import tournoi.football.TP3SpringBoot.repositories.MatchRpo;
import tournoi.football.TP3SpringBoot.repositories.StadeRpo;

import java.util.List;
import java.util.Optional;

@Service
public class StadeService {

    @Autowired
    StadeRpo stadeRpo;
    @Autowired
    MatchRpo matchRpo;
    public Stade saveStade(Stade stade) {
        return stadeRpo.save(stade);
    }

    public ResponseEntity<Stade> findStadeById(Long id) {
        Optional<Stade> stade =stadeRpo.findById(id);

        if (stade.isPresent()) {
            return ResponseEntity.ok(stade.get());
        } else {
            // Gérez le cas où le stade n'a pas été trouvé, par exemple en retournant une réponse HTTP 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
    }
    public List<Stade> listStade() {
        return stadeRpo.findAll();
    }

    public void deleteStade(Long id) {
        stadeRpo.deleteById(id);
    }

    public Stade updateStde(Stade stade, Long id) {

        Optional<Stade> existingStade = stadeRpo.findById(id);

        if (existingStade.isPresent()) {

            Stade updatedStade = existingStade.get();
            updatedStade.setNomStade(stade.getNomStade());
            updatedStade.setVille(stade.getVille());
            //updatedStade.setMatche(stade.getMatche());

            return stadeRpo.save(updatedStade);
        } else {
            return null;


        }
    }

    public Stade getStadeBymatchid(Long id){
        Match match = matchRpo.findById(id).get();
        return match.getStade() ;

    }
}
