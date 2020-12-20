package com.imona.javaassignment.controller;

import com.imona.javaassignment.model.Player;
import com.imona.javaassignment.service.GameService;
import com.imona.javaassignment.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/games/{game_id}/players")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @Autowired
    GameService gameService;

    @GetMapping("")
    public Optional<Set<Player>> getPlayers(@PathVariable (value = "game_id") Long game_id) {
        return playerService.findAllPlayersByGameId(game_id);
    }
    @PostMapping("")
    public Player createPlayer(@PathVariable (value = "game_id") Long game_id, @RequestBody Player player) {
        playerService.createPlayer(player,game_id);
        return player;
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
/*
    @PostMapping({""})
    public String createPlayer(@RequestBody Player player) {
        this.playerService.createPlayer(player);
        return "Saved";
    }*/