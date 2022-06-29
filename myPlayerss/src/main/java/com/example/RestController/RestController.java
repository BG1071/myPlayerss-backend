package com.example.RestController;

import com.example.myplayerss.myPlayers;
import com.example.myplayerss.myTeam;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/*
@RestController
public class RestController {

    @GetMapping
    public List(players) getplayers(){
        return ;
    }

    @Autowired
    public REST_Controller
}
*/

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private myTeam myTeam;

    @Autowired
    public RestController(myTeam myTeam) {
        this.myTeam = myTeam;
    }

    @GetMapping("/player")
    public List<myPlayers> getPlayers(){
        return StreamSupport.stream(
                        myTeam.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @GetMapping("/player/{id}")
    public myPlayers getPlayerById(@PathVariable int id) {
        return getPlayers().stream()
                .filter(player -> player.getId() == id)
                .findFirst()
                .get();
    }

    @PostMapping("/player")
    public myPlayers createPlayer(@RequestBody myPlayers myPlayers) {
        int newId = getPlayers().stream()
                .max((t1,t2) -> Integer.compare(t1.getId(), t2.getId()))
                .get()
                .getId()+1;
        myPlayers.setId(newId);
        getPlayers().add(myPlayers);
        return myPlayers;
    }

    @DeleteMapping("/player/{id}")
    public void deletePlayerById(@PathVariable int id) {
        myPlayers playerToDelete = getPlayers().stream()
                .filter(todo -> todo.getId() == id)
                .findFirst()
                .get();
        getPlayers().remove(playerToDelete.getId());
    }

    @PutMapping("/player/{id}")
    public myPlayers updatePlayer(@PathVariable int id , @RequestBody myPlayers myPlayers) {
        myPlayers playerToUpdate = getPlayers().stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .get();
        playerToUpdate.setName(myPlayers.getName());
        playerToUpdate.setSurname(myPlayers.getSurname());
        playerToUpdate.setBirthdate(myPlayers.getBirthdate());
        playerToUpdate.setClub(myPlayers.getClub());
        playerToUpdate.setId(myPlayers.getId());
        playerToUpdate.setHeight(myPlayers.getHeight());
        playerToUpdate.setNationality(myPlayers.getNationality());
        playerToUpdate.setNumber(myPlayers.getNumber());
        playerToUpdate.setUrl(myPlayers.getUrl());
        playerToUpdate.setWorth(myPlayers.getWorth());
        return playerToUpdate;
    }

}