package tournoi.football.TP3SpringBoot.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import tournoi.football.TP3SpringBoot.entity.Joueur;
import tournoi.football.TP3SpringBoot.entity.Match;
import tournoi.football.TP3SpringBoot.repositories.JoueurRepo;
import tournoi.football.TP3SpringBoot.repositories.MatchRpo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MatchService {

    @Autowired
    MatchRpo matchRpo;

    public Match saveMatch(Match match) {
        return matchRpo.save(match);
    }

    public List<Match> listMatch() {
        return matchRpo.findAll();
    }

    public void deleteMatch(Long id) {
        matchRpo.deleteById(id);
    }


    public List<Match> ListMatchByDate(String date){
        LocalDate localdate = LocalDate.parse(date);
        return matchRpo.findByDateMatch(localdate);

    }
    public Match updatematch(Match match,  Long id) {
        Optional<Match> existingMatch = matchRpo.findById(id);
        if (existingMatch.isPresent()) {
            Match updatedMatch = existingMatch.get();
            updatedMatch.setDateMatch(match.getDateMatch());
            updatedMatch.setHeureMatch(match.getHeureMatch());
            //updatedMatch.setArbitre(match.getArbitre());
            //updatedMatch.setStade(match.getStade());

            return matchRpo.save(updatedMatch);
        } else {

            return null;


        }
    }

    @Transactional
    public void deleteByDateMatchLessThanCurrentDate(){
        matchRpo.deleteByDateMatchLessThan(LocalDate.now()) ;

    }
}
