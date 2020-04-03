package g54786.humbug.model;

/**
 * Makes the snail move. Snail has a specific move pattern.
 *
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public abstract class Snail extends Animal {

    public Snail(Position positiononBoard) {
        super(positiononBoard);
    }

    /**
     * Moves snail in given direction.
     *
     * @param board Board on which the snail must move.
     * @param direction Direction in which the snail must move.
     * @param animal All animals on the board.
     * @return New position after the snail moved.
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animal) {
        Position initPosition = this.getPositionOnBoard();
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
        }
        if (!board.isInside(nextPosition)) {
            this.setPositionOnBoard(null);
            return null;
        }
        return null;
    }
}
