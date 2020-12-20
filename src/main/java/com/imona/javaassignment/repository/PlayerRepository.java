package com.imona.javaassignment.repository;

import com.imona.javaassignment.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Long> {

    List<Player> findAll();
    Optional<Player> findById(Long id);
    Optional<Player> findByIdAndGameId(Long gameId, Long id);

}
