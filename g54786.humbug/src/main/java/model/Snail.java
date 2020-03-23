/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Makes the snail move. Snail has a specific move pattern.
 *
 * @author router
 */
public abstract class Snail extends Animal {

    public Snail(Position positiononBoard) {
        super(positiononBoard);
    }

    /**
     * Moves snail in given direction.
     *
     * @param board board on which the snail must move.
     * @param direction direction in which the snail must move.
     * @param animal all animals on the board.
     * @return new position after it moved.
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animal) {
        for (int move = 0; move < 1; move++) {
            Position initPosition = getPositionOnBoard();
            Position nextPosition = initPosition.next(direction);
            if (!board.isInside(nextPosition)) {
                this.setPositionOnBoard(null);
                return null;
            }
            for (Animal animals : animal) {
                if (animals.getPositionOnBoard().equals(nextPosition)) {
                    return initPosition;
                }
            }
            if (nextPosition != null
                    && board.getSquareType(nextPosition)
                    == SquareType.STAR) {
                setOnStar(true);
                board.setSquareType(nextPosition, SquareType.GRASS);
                return nextPosition;
            } else return nextPosition;
        }
        return null;
    }
}
