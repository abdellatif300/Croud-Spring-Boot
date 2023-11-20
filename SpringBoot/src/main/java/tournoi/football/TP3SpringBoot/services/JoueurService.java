package tournoi.football.TP3SpringBoot.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import tournoi.football.TP3SpringBoot.entity.Equipe;
import tournoi.football.TP3SpringBoot.entity.Joueur;
import tournoi.football.TP3SpringBoot.repositories.EquipeRepo;
import tournoi.football.TP3SpringBoot.repositories.JoueurRepo;

import java.util.List;
import java.util.Optional;

@Service
public class JoueurService {
    @Autowired
    JoueurRepo joueurRepo;
    @Autowired
    EquipeRepo equipeRepo;
    public Joueur saveJoueur(Joueur joueur) {

        return joueurRepo.save(joueur);
    }

    public List<Joueur> listJoueur() {
        return joueurRepo.findAll();
    }

    public void deleteJoueur(Long id) {
        joueurRepo.deleteById(id);
    }
    public List<Joueur> getJoueurByNomEquipe(String nom) {
        return joueurRepo.findByEquipeNomEquipe(nom);
    }
    public List<Joueur> getJoueurByNomEquipeAndPost(String nom , String poste) {
        return joueurRepo.findByEquipeNomEquipeAndPoste(nom,poste);
    }


    public Joueur updateJoueur(Joueur joueur, Long id) {

        Optional<Joueur> existingJoueur = joueurRepo.findById(id);
        if (existingJoueur.isPresent()) {

            Joueur updatedJoueur = existingJoueur.get();
            updatedJoueur.setNomJoueur(joueur.getNomJoueur());
            updatedJoueur.setPoste(joueur.getPoste());
            //updatedJoueur.setEquipe(joueur.getEquipe());

            return joueurRepo.save(updatedJoueur);
        } else {

            return null;


        }
    }
}
