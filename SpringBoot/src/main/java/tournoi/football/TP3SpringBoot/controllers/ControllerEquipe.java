package tournoi.football.TP3SpringBoot.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tournoi.football.TP3SpringBoot.entity.Arbitre;
import tournoi.football.TP3SpringBoot.entity.Equipe;
import tournoi.football.TP3SpringBoot.repositories.EquipeRepo;
import tournoi.football.TP3SpringBoot.services.EquipeService;

import javax.security.auth.callback.LanguageCallback;
import java.util.List;

@RestController

public class ControllerEquipe {

    @Autowired
    EquipeService equipeService;
    @PostMapping("equipe")
    public Equipe saveEquipe(@RequestBody Equipe equipe){

        return equipeService.saveEquipe(equipe);
    }

    @GetMapping("equipe")
    public List<Equipe> fidAllEquipe(){
        return equipeService.listEquipe();
    }
    @DeleteMapping("equipe/{id}")
    public void DeleteEquipe(@PathVariable Long id){
        equipeService.deleteEquipe(id);
    }

    //Récupérer toutes les équipes du ‘Maroc’
    @GetMapping("equipe/pays/{pays}")
    public  List<Equipe> findPys(@PathVariable String pays){

        return equipeService.findByPays(pays);
    }

   // Récupérer les deux équipes du math de l’id=3

    @GetMapping("equipe/match/{id}")
    public List<Equipe> getEquipesBymatchId(@PathVariable Long id) {
        return equipeService.getEquipesBymatchId(id);
    }

    @PutMapping("equipe/{id}")
    public Equipe update(@RequestBody Equipe equipe, @PathVariable Long id){
        return equipeService.updateEquipe(equipe,id);
    }




}
