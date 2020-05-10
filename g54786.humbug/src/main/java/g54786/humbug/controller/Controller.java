package g54786.humbug.controller;

import g54786.humbug.view.text.InterfaceView;
import g54786.humbug.model.Model;
import g54786.humbug.model.Direction;
import g54786.humbug.model.Position;
import g54786.humbug.model.LevelStatus;

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
        while (game.getLevelStatus() != LevelStatus.NOT_STARTED) {
            view.displayCaption();
            view.displayLevel(nLevel);
            game.startLevel(nLevel);
            while (game.getLevelStatus() == LevelStatus.IN_PROGRESS) {
                view.displayRemaningMoves(game.getRemainingMoves());
                view.displayBoard(game.getBoard(), game.getAnimals());
                Position position = view.askPosition();
                Direction direction = view.askDirection();
                try {
                    game.move(position, direction);
                } catch (IllegalArgumentException e) {
                    view.displayError("You fell into the void!");
                }
            }
            switch (game.getLevelStatus()) { //Evaluates level status and acts 
                //accordingly
                case FAIL:
                    System.out.println("Game over!");
                    break;
                case WIN:
                    view.displayBoard(game.getBoard(), game.getAnimals());
                    System.out.println("Congratulations, you have won this"
                            + " level!");
                    nLevel++;
                    break;
                default:
                    System.out.println("Thank you for playing Humbug!");
                    break;
            }
        }
    }
}
