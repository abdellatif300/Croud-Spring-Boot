package tournoi.football.TP3SpringBoot.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tournoi.football.TP3SpringBoot.entity.Arbitre;
import tournoi.football.TP3SpringBoot.services.ArbitreService;

import java.util.List;

@RestController
@CrossOrigin
public class ControllerArbitre {

    @Autowired
    ArbitreService arbitreService;


    @PostMapping("arbitre")
    public Arbitre saveArbitre(@RequestBody Arbitre arbitre){
        return arbitreService.saveArbitre(arbitre);
    }
    @GetMapping("arbitre")
    public List<Arbitre> fidAllarbitre(){

        return arbitreService.listArbitre();

    }

    @DeleteMapping("arbitre/{id}")
    public void  deletArbitre(@PathVariable Long id){
        arbitreService.deleteArbitre(id);
    }

    @PutMapping("arbitre/{id}")
    public Arbitre update(@RequestBody Arbitre arbitre, @PathVariable Long id){

        return arbitreService.updateArbitre(arbitre,id);
    }





}
