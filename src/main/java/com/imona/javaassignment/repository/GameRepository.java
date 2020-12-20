package com.imona.javaassignment.repository;

import com.imona.javaassignment.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game,Long>{

    List<Game> findAll();
    Optional<Game> findById(Long id);


}
