/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Makes the spider move. Spider has a specific move pattern.
 * @author router
 */
public abstract class Spider extends Animal {

    public Spider(Position positiononBoard) {
        super(positiononBoard);
    }

    /**
     * Moves spider in given direction.
     *
     * @param board The board in which the spider will move.
     * @param direction The direction chosen by the user that the spider will
     * follow.
     * @param animal All animals that are on board.
     * @return New position of spider. It can be or off the board since it
     * reached a STAR, or, stuck somewhere on the board.
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animal) {
        Position nextPosition = getPositionOnBoard().next(direction);
        while (board.isInside(nextPosition)) {
            Position initPosition = getPositionOnBoard();
            nextPosition = initPosition.next(direction);
            if (!board.isInside(nextPosition)) {
                this.setPositionOnBoard(null);
                return null;
            }
            for (Animal animals : animal) {
                if (animals.getPositionOnBoard().equals(nextPosition)) {
                    return initPosition;
                }
            }
            if (board.getSquareType(nextPosition) == SquareType.STAR 
                    && !ableToMove(nextPosition, board, direction, animal)){
                setOnStar(true);
                board.setSquareType(nextPosition, SquareType.STAR);
                return nextPosition;
        }
        
    }
        return null;
}
    /**
     * Checks if after the given position the spider is still able to move.
     * 
     * @param pos 
     * @param board
     * @param direction direction in which this method will check.
     * @param animal
     * @return 
     */
    public boolean ableToMove (Position pos ,Board board, Direction direction, Animal... animal){
        Position nextPosition = pos.next(direction);
        boolean ableToMove = true;
        for (Animal animals : animal) {
            while (board.isInside(pos.next(direction))){
                if (animals.getPositionOnBoard().equals(nextPosition)){
                    ableToMove = false;
                }
            }
        }
        return ableToMove;
    }   
}

