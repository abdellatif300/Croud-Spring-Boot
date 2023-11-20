package tournoi.football.TP3SpringBoot.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import tournoi.football.TP3SpringBoot.entity.Arbitre;

import tournoi.football.TP3SpringBoot.repositories.ArbitreRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ArbitreService {

    @Autowired
    ArbitreRepo arbitreRepo;

    public Arbitre saveArbitre(Arbitre arbitre) {
        return arbitreRepo.save(arbitre);
    }

    public List<Arbitre> listArbitre() {
        return arbitreRepo.findAll();
    }

    public void deleteArbitre(Long id) {
        arbitreRepo.deleteById(id);
    }

    public Arbitre updateArbitre(Arbitre arbitre, Long id) {
        Optional<Arbitre> existingArbitre = arbitreRepo.findById(id);
        if (existingArbitre.isPresent()) {
            Arbitre updatedArbitre = existingArbitre.get();
            updatedArbitre.setNom(arbitre.getNom());
            updatedArbitre.setNationalite(arbitre.getNationalite());
            return arbitreRepo.save(updatedArbitre);
        } else {
            return null;
        }
    }
}
