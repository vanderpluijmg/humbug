package g54786.humbug.model.Animal;

import g54786.humbug.model.Animal.Animal;
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
        Position initPosition = getPositionOnBoard();
        Position nextPosition = initPosition.next(direction);
        while (board.isInside(nextPosition)) {
            initPosition = getPositionOnBoard();
            nextPosition = initPosition.next(direction);
            for (Animal animal : animals) {
                if (animal.getPositionOnBoard().equals(nextPosition)) {
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
