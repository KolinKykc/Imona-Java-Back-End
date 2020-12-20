package com.imona.javaassignment.controller;

import com.imona.javaassignment.model.Player;
import com.imona.javaassignment.service.GameService;
import com.imona.javaassignment.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @Autowired
    GameService gameService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public ResponseEntity<List<Player>> getPlayers() {
        List<Player> players = playerService.allPlayers();
        return ResponseEntity.ok(players);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<?> getPlayer(@PathVariable("id") Long id) {
        try {
            Optional<Player> player = playerService.findPlayer(id);
            return ResponseEntity.ok(player);
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping({""})
    public String createPlayer(@RequestBody Player player) {
        this.playerService.createPlayer(player);
        return "Saved";
    }
    @PutMapping({"/{id}"})
    public String updatePlayer(@PathVariable Long id, @RequestBody Player player) {
        this.playerService.updatePlayer(id, player);
        return "updated";
    }
    @DeleteMapping({"/{id}"})
    public String readPlayer(@PathVariable long id) {
        this.playerService.deletePlayer(id);
        return "deleted";
    }





}
