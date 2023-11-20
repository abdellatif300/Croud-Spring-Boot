package tournoi.football.TP3SpringBoot.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tournoi.football.TP3SpringBoot.entity.Equipe;
import tournoi.football.TP3SpringBoot.entity.Match;
import tournoi.football.TP3SpringBoot.repositories.MatchRpo;
import tournoi.football.TP3SpringBoot.services.MatchService;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ControllerMatch {
    @Autowired
    MatchService matchService;


    @PostMapping("matches")
    public Match saveMatch(@RequestBody Match match){

        return matchService.saveMatch(match);
    }

    @GetMapping(" ")
    public List<Match> findMatch(){
        return matchService.listMatch();
    }
    @DeleteMapping("matches/delete/{id}")
    public void deletmatch(@PathVariable Long id){
        matchService.deleteMatch(id);
    }


    //Récupérer les matchs qui sont programmés le ‘28/02/2021’


    @GetMapping("matches/date/{date}")
    public List<Match> findMatchBydate(@PathVariable String date){

        return matchService.ListMatchByDate(date);
    }

    @PutMapping("matches/update/{id}")
    public Match update(@RequestBody Match match, @PathVariable Long id){

        return matchService.updatematch(match,id);
    }

    //Supprimer tous les matchs déjà passés
    @DeleteMapping("match/{date}")
    void deleteByDateMatchLessThanCurrentDate(){
        matchService.deleteByDateMatchLessThanCurrentDate() ;

    }
}
