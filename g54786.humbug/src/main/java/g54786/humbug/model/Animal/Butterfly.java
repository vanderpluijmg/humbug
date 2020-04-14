/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54786.humbug.model.Animal;

import g54786.humbug.model.Board;
import g54786.humbug.model.Direction;
import g54786.humbug.model.Position;
import g54786.humbug.model.SquareType;

/**
 * Makes the butterfly move. Butterfly has a specific move pattern.
 *
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public class Butterfly extends Animal {

    public Butterfly(Position positiononBoard) {
        super(positiononBoard);
    }

    /**
     * Moves butterfly in given direction.
     *
     * @param board Board on which the butterfly must move.
     * @param direction Direction in which the butterfly must move.
     * @param animals All animals on the board.
     * @return New position after the butterfly moved.
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {

        Position nextPosition = getPositionOnBoard().next(direction)
                .next(direction).next(direction);

        try {
            board.getSquareType(nextPosition);
        } catch (IllegalArgumentException e) {
            setPositionOnBoard(null);
            return null;
        }
        for (Animal animal : animals) {
            if (animal.getPositionOnBoard().equals(nextPosition)) {
                if (!board.isInside(nextPosition.next(direction))) {
                    setPositionOnBoard(null);
                    return null;
                }
                setPositionOnBoard(nextPosition.next(direction));
                if (board.getSquareType(getPositionOnBoard())
                        == SquareType.STAR) {
                    setOnStar(true);
                    board.setSquareType(getPositionOnBoard(), SquareType.GRASS);
                }
                nextPosition = nextPosition.next(direction);
            }
        }
        if (board.getSquareType(nextPosition) == SquareType.STAR) {
            setOnStar(true);
            setPositionOnBoard(nextPosition);
            board.setSquareType(nextPosition, SquareType.GRASS);
            return nextPosition;
        } else {
            setPositionOnBoard(nextPosition);
            return nextPosition;
        }
    }
}

