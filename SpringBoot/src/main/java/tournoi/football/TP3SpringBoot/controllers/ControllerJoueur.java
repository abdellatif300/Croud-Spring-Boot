package tournoi.football.TP3SpringBoot.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tournoi.football.TP3SpringBoot.entity.Joueur;
import tournoi.football.TP3SpringBoot.services.JoueurService;

import java.util.List;

@RestController
public class ControllerJoueur {

    @Autowired
    JoueurService joueurService;

    @PostMapping("joueurs")
    public Joueur saveJoueur(@RequestBody Joueur joueur){

        return joueurService.saveJoueur(joueur);

    }

    @GetMapping("joueurs")
    public List<Joueur> fidJoueur(){

        return joueurService.listJoueur();
    }

    @DeleteMapping("joueurs/{id}")
    public void deletJoueurbyId(@PathVariable Long id){

        joueurService.deleteJoueur(id);
    }

    @PutMapping("joueurs/{id}")
    public  Joueur update(@RequestBody Joueur joueur, @PathVariable Long id){
        return joueurService.updateJoueur(joueur,id);
    }

    //Récupérer tous les joueurs de l’équipe ‘ATL MADRID’

    @GetMapping("joueur/equipe/{nom}")
    public List<Joueur> getJoueurByNomEquipe(@PathVariable String nom) {
        return joueurService.getJoueurByNomEquipe(nom);
    }

    //Récupérer tous les joueurs de poste=’attaquant’ de l’équipe ‘PSG’

    @GetMapping("joueur/equipe/{nom}/{poste}")
    public List<Joueur> getJoueurByNomEquipeAndPost(@PathVariable String nom,@PathVariable String poste) {
        return joueurService.getJoueurByNomEquipeAndPost(nom, poste);
    }
}
