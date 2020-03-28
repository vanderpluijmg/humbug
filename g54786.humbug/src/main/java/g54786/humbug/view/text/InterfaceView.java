/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54786.humbug.view.text;

import g54786.humbug.model.Animal;
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
     * Displays the given board in a new String Array, does not show null.
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

}
