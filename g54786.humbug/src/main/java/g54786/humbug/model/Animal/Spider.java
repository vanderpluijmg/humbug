package g54786.humbug.model.Animal;

import g54786.humbug.model.Board;
import g54786.humbug.model.Direction;
import g54786.humbug.model.Position;
import g54786.humbug.model.SquareType;

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
     * Moves spider in given direction.
     *
     * @param board Board on which the spider must move.
     * @param direction Direction in which the spider must move.
     * @param animals All animals on the board.
     * @return New position after the spider moved.
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {

        Position nextPosition = getPositionOnBoard().next(direction);
    
        while (board.isInside(nextPosition)) {
            nextPosition = getPositionOnBoard().next(direction);
            for (Animal animal : animals) {
                if (animal.getPositionOnBoard().equals(nextPosition)) {
                    if (board.getSquareType(getPositionOnBoard()) == SquareType.STAR) {
                        setOnStar(true);
                        board.setSquareType(getPositionOnBoard(), SquareType.GRASS);
                        setPositionOnBoard(getPositionOnBoard());
                        return getPositionOnBoard();
                    }
                    setPositionOnBoard(getPositionOnBoard());
                    return getPositionOnBoard();
                }
            }

            setPositionOnBoard(nextPosition);
            nextPosition = nextPosition.next(direction);
        }
        setPositionOnBoard(null);
        return null;

    }
}
