package com.imona.javaassignment.controller;

import com.imona.javaassignment.model.Game;
import com.imona.javaassignment.model.Player;
import com.imona.javaassignment.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/games"})
public class GameController {

    @Autowired
    private GameService gameService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public ResponseEntity<List<Game>> getGames() {
        List<Game> games = gameService.allGame();
        return ResponseEntity.ok(games);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<?> getGames(@PathVariable("id") Long id) {
        try {
            Optional<Game> game = gameService.findGame(id);
            return ResponseEntity.ok(game);
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping({""})
    public String createPlayer(@RequestBody Game game) {
        this.gameService.createGame(game);
        return "Saved";
    }
    @PutMapping({"/{id}"})
    public String updatePlayer(@PathVariable Long id, @RequestBody Game game) {
        this.gameService.updateGame(id,game);
        return "updated";
    }
    @DeleteMapping({"/{id}"})
    public String readPlayer(@PathVariable long id) {
        this.gameService.deleteGame(id);
        return "deleted";
    }


}
