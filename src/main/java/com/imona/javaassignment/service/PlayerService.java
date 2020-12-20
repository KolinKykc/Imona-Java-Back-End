package com.imona.javaassignment.service;

import com.imona.javaassignment.model.Player;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public interface PlayerService {

    Player createPlayer(Player player, Long game_id);

    void deletePlayer(Long id);
    void updatePlayer(Long id, Player player);
    List<Player> allPlayers();
    Optional<Player> findPlayer(Long id);
    Optional<Set<Player>> findAllPlayersByGameId(Long game_id);

}
