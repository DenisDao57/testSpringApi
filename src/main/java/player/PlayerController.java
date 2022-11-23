package player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PlayerController {

    @Autowired
    private IPlayerDAO dao;

    @ResponseBody
    @GetMapping(value="/players",produces = "application/json")
    public ArrayList<Player> getAllPlayers(){
        return dao.findAll();
    }

    @ResponseBody
    @GetMapping(value="/players/3pts",produces = "application/json")
    public Player getBest3pts(){
        return dao.findBest3pts();
    }

    @ResponseBody
    @GetMapping(value="/players/{poste}",produces = "application/json")
    public ArrayList<Player> getPlayersByPost(@PathVariable String poste){
        return dao.findByPost(poste);
    }

    @ResponseBody
    @PostMapping(value="/players", consumes = "application/json", produces = "application/json")
    public String addPlayer(@RequestBody Player player){
        dao.addPlayer(player);
        return "Bien joué, le joueur a été ajouté !";
    }

    @ResponseBody
    @DeleteMapping(value="/players/{name}", consumes = "application/json", produces = "application/json")
    public String deletePlayer(@PathVariable String name){
        if (dao.deletePlayerByName(name))  return "Bien joué, "+name+" est mort !";
        return "Mince,"+name+" n'existe pas !";
    }

}
