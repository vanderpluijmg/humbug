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
        while (game.getLevelStatus() != LevelStatus.NOT_STARTED){
            game.startLevel(nLevel);
            while (game.getLevelStatus() == LevelStatus.IN_PROGRESS){
                view.displayRemaningMoves(game.getRemainingMoves());
                view.displayBoard(game.getBoard(), game.getAnimals());
                Direction direction = view.askDirection();
                Position position = view.askPosition();
                try {
                    game.move(position, direction);
                } catch (IllegalArgumentException nonValidMove) {
                    view.displayError("You fell in the water!");
                    }
                }
              
            switch (game.getLevelStatus()) {
            case WIN:
                view.displayBoard(game.getBoard(), game.getAnimals());
                System.out.println("Congratulations, you have won this level!");
                nLevel++;
                break;
            case FAIL:
                System.out.println("Game over!");
                break;
            default:
                System.out.println("You have completed all levels in the game, "
                        + "well done!");
                break;
            }
        }     
    }
}