package com.imona.javaassignment.service;

import com.imona.javaassignment.model.Action;
import java.util.List;
import java.util.Optional;

public interface ActionService {

    void createAction(Action action);
    void deleteAction(Long id);
    void updateAction(Long id, Action action);
    List<Action> allAction();
    Optional<Action> findAction(Long id);


}
