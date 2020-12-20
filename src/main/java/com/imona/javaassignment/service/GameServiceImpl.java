package com.imona.javaassignment.service;

import com.imona.javaassignment.model.Game;
import com.imona.javaassignment.repository.GameRepository;
import com.imona.javaassignment.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    @Override
    public void createGame(Game game) {
        this.gameRepository.save(game);

    }
    @Override
    public void deleteGame(Long id) {
        this.gameRepository.deleteById(id);
    }

    @Override
    public void updateGame(Long id, Game game) {
        Optional<Game> existedGame = this.gameRepository.findById(id);
        if (!existedGame.isPresent()) {
            throw new UnsupportedOperationException("The game you are looking for does not exist");
        } else {
            Game exGame = (Game) existedGame.get();
            exGame.setName(game.getName());
            exGame.setDescription(game.getDescription());
            exGame.setLogoUrl(game.getLogoUrl());
            this.gameRepository.save(exGame);
        }
    }

    @Override
    public List<Game> allGame() {
        List<Game> gameList = new ArrayList();
        gameList = gameRepository.findAll();
        return gameList;
    }

    @Override
    public Optional<Game> findGame(Long id) {
        Optional<Game> game = gameRepository.findById(id);
        return game;
    }
}