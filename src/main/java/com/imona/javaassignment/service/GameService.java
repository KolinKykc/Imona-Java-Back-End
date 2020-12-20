package com.imona.javaassignment.service;

import com.imona.javaassignment.model.Game;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface GameService {

    void createGame(Game game);
    void deleteGame(Long id);
    void updateGame(Long id, Game game);
    List<Game> allGame();
    Optional<Game> findGame(Long id);


}
