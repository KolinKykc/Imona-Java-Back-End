package com.imona.javaassignment.service;

import com.imona.javaassignment.model.Player;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface PlayerService {

    void createPlayer(Player player);
    void deletePlayer(Long id);
    void updatePlayer(Long id, Player player);
    List<Player> allPlayers();
    Optional<Player> findPlayer(Long id);

}
