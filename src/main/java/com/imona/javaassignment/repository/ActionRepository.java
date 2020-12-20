package com.imona.javaassignment.repository;

import com.imona.javaassignment.model.Action;
import com.imona.javaassignment.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActionRepository extends JpaRepository<Action,Long> {

    List<Action> findAll();
    Optional<Action> findById(Long id);
    Optional<Action> findByIdAndGameId(Long gameId, Long id);

}