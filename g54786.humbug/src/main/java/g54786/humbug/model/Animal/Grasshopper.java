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
 *
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public class Grasshopper extends Animal {

    public Grasshopper(Position positiononBoard) {
        super(positiononBoard);
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

        Position nextPosition = getPositionOnBoard().next(direction);

        while (board.isInside(nextPosition)) {
            for (Animal animal : animals) {
                while (animal.getPositionOnBoard().equals(nextPosition)) {
                    if (board.getSquareType(getPositionOnBoard()) == SquareType.STAR) {
                        setOnStar(true);
                        board.setSquareType(getPositionOnBoard(), SquareType.GRASS);
                        setPositionOnBoard(getPositionOnBoard());
                        return getPositionOnBoard();
                    }
                    nextPosition = nextPosition.next(direction);
                    setPositionOnBoard(nextPosition);
                }
            }
            setPositionOnBoard(nextPosition);
            return nextPosition;
        }
        if (board.getSquareType(getPositionOnBoard()) == SquareType.STAR) {
            setOnStar(true);
            board.setSquareType(getPositionOnBoard(), SquareType.GRASS);
            setPositionOnBoard(getPositionOnBoard());
            return getPositionOnBoard();
        }

        setPositionOnBoard(null);
        return null;
    }
}
