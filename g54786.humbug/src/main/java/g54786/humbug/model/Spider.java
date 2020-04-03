package g54786.humbug.model;

/**
 * Makes the spider move. Spider has a specific move pattern.
 *
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public abstract class Spider extends Animal {

    public Spider(Position positiononBoard) {
        super(positiononBoard);
    }

    /**
     * Moves snail in given direction.
     *
     * @param board Board on which the spider must move.
     * @param direction Direction in which the spider must move.
     * @param animal All animals on the board.
     * @return New position after the spider moved.
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animal) {
        Position initPosition = getPositionOnBoard();
        Position nextPosition = initPosition.next(direction);
        while (board.isInside(nextPosition)) {
            initPosition = getPositionOnBoard();
            nextPosition = initPosition.next(direction);
            for (Animal animals : animal) {
                if (animals.getPositionOnBoard().equals(nextPosition)) {
                    setPositionOnBoard(initPosition);
                    return initPosition;

                } else if (SquareType.STAR == board.getSquareType(nextPosition)) {
                        setOnStar(true);
                        setPositionOnBoard(nextPosition);
                        board.setSquareType(nextPosition, SquareType.GRASS);
                        return nextPosition;
                } else {
                        setPositionOnBoard(nextPosition);
                        return nextPosition;
                    }
                }
            
            setPositionOnBoard(nextPosition);
        }
        if (!board.isInside(nextPosition)) {
            this.setPositionOnBoard(null);
            return null;
        }
        return null;
    }

}
