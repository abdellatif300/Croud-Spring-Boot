package tournoi.football.TP3SpringBoot.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tournoi.football.TP3SpringBoot.entity.Equipe;
import tournoi.football.TP3SpringBoot.repositories.EquipeRepo;

import java.util.List;
import java.util.Optional;

@Service
public class EquipeService {


    @Autowired
    EquipeRepo equipeRepo;

    public Equipe saveEquipe(Equipe equipe) {
        return equipeRepo.save(equipe);
    }

    public List<Equipe> listEquipe() {
        return equipeRepo.findAll();
    }

    public void deleteEquipe(Long id) {
        equipeRepo.deleteById(id);
    }


    public  List<Equipe> findByPays(String pays){
        return equipeRepo.findByPays(pays);

    }

    public List<Equipe> getEquipesBymatchId(Long id) {
        return equipeRepo.findByMatchesIdMatch(id);
    }
    public Equipe updateEquipe(Equipe equipe, Long id) {
        Optional<Equipe> existingEquipe = equipeRepo.findById(id);
        if (existingEquipe.isPresent()) {
            Equipe updatedEquipe = existingEquipe.get();
            updatedEquipe.setNomEquipe(equipe.getNomEquipe());
            updatedEquipe.setPays(equipe.getPays());
            //updatedEquipe.setJoueur(equipe.getJoueur());
            return equipeRepo.save(updatedEquipe);
        } else {
            return null;


        }
    }
}
