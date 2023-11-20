package tournoi.football.TP3SpringBoot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tournoi.football.TP3SpringBoot.entity.Stade;
import org.springframework.http.ResponseEntity;
import tournoi.football.TP3SpringBoot.services.StadeService;
import java.util.List;

@RestController

public class ControllerStade {

    @Autowired
    StadeService stadeService;

    @GetMapping("stades")
    public List<Stade> listStade(){
        return stadeService.listStade();
    }

    @GetMapping("stades/{id}")
    public ResponseEntity<Stade> findStadeById(@PathVariable Long id) {
          return stadeService.findStadeById(id);
    }

    @PostMapping("stades")
    public  Stade saveStade(@RequestBody Stade stade){
        return stadeService.saveStade(stade);
    }

    @DeleteMapping("stades/{id}")
    public void deletstade(@PathVariable Long id ){
        stadeService.deleteStade(id);
    }

//    @PutMapping("updateStade/{id}")
//    public Stade updateStade(@RequestBody Stade stade,@PathVariable Long id) {
//        return stadeService.updateStde(stade,id);
//
//      }
    ///Récupérer le stade où se déroule le match de l’id=3
    @GetMapping("stades/match/{id}")
    public Stade getStadeBymatchid(@PathVariable Long id) {
        return stadeService.getStadeBymatchid(id);
    }
}






