package com.imona.javaassignment.service;

import com.imona.javaassignment.model.Action;
import com.imona.javaassignment.repository.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ActionServiceImpl implements ActionService {

    @Autowired
    private ActionRepository actionRepository;

    @Override
    public void createAction(Action action) {
        this.actionRepository.save(action);
    }

    @Override
    public void deleteAction(Long id) {
        this.actionRepository.deleteById(id);
    }

    @Override
    public void updateAction(Long id, Action action) {

        Optional<Action> existedAction = this.actionRepository.findById(id);
        if (!existedAction.isPresent()) {
            throw new UnsupportedOperationException("The game you are looking for does not exist");
        } else {
            Action exAction = (Action) existedAction.get();
            exAction.setName(action.getName());
            exAction.setDescription(action.getDescription());
            this.actionRepository.save(exAction);

        }
    }

    @Override
    public List<Action> allAction() {
            List<Action> actionList =new ArrayList();
            actionList =actionRepository.findAll();
            return actionList;
    }

    @Override
    public Optional<Action> findAction(Long id) {
        Optional<Action> action =actionRepository.findById(id);
        return action;
    }
}