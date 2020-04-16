package g54786.humbug.controller;

import g54786.humbug.view.text.InterfaceView;
import g54786.humbug.model.Model;
import g54786.humbug.model.Direction;
import g54786.humbug.model.Position;
import g54786.humbug.model.Board;
import g54786.humbug.model.Level;

/**
 * Controller is responsible for game dynamics and updates view after each move.
 *
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public class Controller {

    private Model game;
    private InterfaceView view;

    /**
     * Constructor for controller.
     *
     * @param game Model interface.
     * @param view InterfaceView interface.
     */
    public Controller(Model game, InterfaceView view) {
        this.game = game;
        this.view = view;
    }

    /**
     * Interacts with user.
     *
     * @param nLevel Level to start at.
     */
    public void startGame(int nLevel) {
        boolean levelIsNotOver = true;
        game.startLevel(1);
        view.displayRemaningMoves(game.getRemainingMoves());
        while (levelIsNotOver) {
            view.displayBoard(Board.getInitialBoard(), game.getAnimals());
            Position position = view.askPosition();
            Direction direction = view.askDirection();
            try { //Tries to move the animal
                game.move(position, direction);
            } catch (IllegalArgumentException nonValidMove) {
                levelIsNotOver = false;
                view.displayError("You fell in the water!");
            }
        }

    }
}
