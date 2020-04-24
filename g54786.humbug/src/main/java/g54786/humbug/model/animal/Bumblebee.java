/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54786.humbug.model.animal;

import g54786.humbug.model.Board;
import g54786.humbug.model.Direction;
import g54786.humbug.model.Position;
import g54786.humbug.model.SquareType;

/**
 * Makes the bumblebee move. Bumblebee has a specific move pattern.
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public abstract class Bumblebee extends Animal {

    public Bumblebee(Position positiononBoard) {
        super(positiononBoard);
    }

    public Bumblebee() {
    }
    /**
     * Moves bumblebee in given direction.
     * @param board Board on which the bumblebee must move.
     * @param direction Direction in which the bumblebee must move.
     * @param animals All animals on the board.
     * @return New position after the bumblebee moved.
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        Position finalPosition = getPositionOnBoard().next(direction)
                    .next(direction);
         return moveOneFlying(board, direction, finalPosition, animals);
        }
    }
