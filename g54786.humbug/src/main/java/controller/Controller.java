/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.text.InterfaceView;
import model.Model;
import model.Direction;
import model.Position;
import model.Board;

/**
 * Controller is responsible for game dynamics and updates view after each move.
 *
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public class Controller {

    private final Model game;
    private final InterfaceView view;
    /**
     * Constructor for controller.
     * @param game Model interface.
     * @param view InterfaceView interface.
     */
    public Controller(Model game, InterfaceView view) {
        this.game = game;
        this.view = view;
    }
    
    /**
     * Interacts with user.
     */
    public void startGame() {
        game.startLevel(1);
        while (!game.levelIsOver()) {
            view.displayBoard(Board.getInitialBoard(), game.getAnimals());
            Direction direction = view.askDirection();
            Position position = view.askPosition();
            try { //Tries to move the animal
                game.move(position, direction);
            } catch (IllegalArgumentException nonValidMove) {
                view.displayError("Non valid move");
            }

        }
    }

}
