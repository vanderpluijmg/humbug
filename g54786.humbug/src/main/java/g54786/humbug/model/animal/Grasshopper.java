/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54786.humbug.model.animal;

import g54786.humbug.model.Board;
import g54786.humbug.model.Direction;
import g54786.humbug.model.Position;

/**
 *
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public class Grasshopper extends Animal {

    public Grasshopper(Position positiononBoard) {
        super(positiononBoard);
    }

    public Grasshopper() {
    }

    /**
     * Moves Grasshopper in given direction.
     *
     * @param board Board on which the grasshopper must move.
     * @param direction Direction in which the grasshopper must move.
     * @param animals All animals on the board.
     * @return New position after the grasshopper moved.
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        return moveOneJumping(board, direction, animals);
    }
}
