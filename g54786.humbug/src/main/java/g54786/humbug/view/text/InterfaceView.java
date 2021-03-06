package g54786.humbug.view.text;

import g54786.humbug.model.animal.Animal;
import g54786.humbug.model.Board;
import g54786.humbug.model.Direction;
import g54786.humbug.model.Position;

/**
 * This is an interface for view class.
 *
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public interface InterfaceView {

    /**
     * Displays the given board in a new String Array, null is blank.
     *
     * @param board Board given to display.
     * @param animal All animals on board.
     */
    void displayBoard(Board board, Animal... animal);

    /**
     * Asks user for a position.
     *
     * @return The position given by row and column coordinates.
     */
    Position askPosition();

    /**
     * Asks user for a direction.
     *
     * @return he direction given by the user.
     */
    Direction askDirection();

    /**
     * Displays error message.
     *
     * @param message Message to display.
     */
    void displayError(String message);

    /**
     * Displays number of remaining moves.
     *
     * @param remainingMoves Number of remaining moves.
     */
    void displayRemaningMoves(int remainingMoves);

    /**
     * Displays caption to know which animal is what.
     */
    void displayCaption();

    /**
     * Displays current level.
     *
     * @param n Level to display.
     */
    void displayLevel(int n);
}
