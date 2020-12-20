package com.imona.javaassignment.service;

import com.imona.javaassignment.model.Game;
import com.imona.javaassignment.model.Player;
import com.imona.javaassignment.repository.GameRepository;
import com.imona.javaassignment.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PlayerServiceImpl implements PlayerService{

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    GameRepository gameRepository;

    @Override
    public List<Player> allPlayers() {

        List<Player> playerList = new ArrayList();
        playerList = playerRepository.findAll();
        return playerList;
    }

    @Override
    public Optional<Player> findPlayer(Long id) {
        Optional<Player> player = playerRepository.findById(id);
        return player;
    }

    @Override
    public Optional<Set<Player>> findAllPlayersByGameId(Long game_id) {
        Optional<Set<Player>> playerList;
        playerList = gameRepository.findById(game_id).map(Game::getPlayerSet);
        return playerList;
    }


    @Override
    public Player createPlayer(Player player, Long game_id) {
        Optional<Game> game = gameRepository.findById(game_id);
        game.ifPresent(game1 -> player.setGame(game1));
        this.playerRepository.save(player);
        return player;
    }

    @Override
    public void deletePlayer(Long id) {
        this.playerRepository.deleteById(id);
    }

    @Override
    public void updatePlayer(Long id, Player player) {
        Optional<Player> existedPlayer = this.playerRepository.findById(id);
        if (!existedPlayer.isPresent()) {
            throw new UnsupportedOperationException("The player you are looking for does not exist");
        } else {
            Player exPlayer = (Player) existedPlayer.get();
            exPlayer.setName(player.getName());
            exPlayer.setSurname(player.getSurname());
            exPlayer.setGender(player.getGender());
            exPlayer.setBirthDate(player.getBirthDate());
            exPlayer.setBirthCity(player.getBirthCity());
            exPlayer.setActive(player.getActive());
            this.playerRepository.save(exPlayer);
        }
    }


}
