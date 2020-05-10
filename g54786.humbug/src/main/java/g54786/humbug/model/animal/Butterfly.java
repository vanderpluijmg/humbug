package g54786.humbug.model.animal;

import g54786.humbug.model.Board;
import g54786.humbug.model.Direction;
import g54786.humbug.model.Position;

/**
 * Makes the butterfly move. Butterfly has a specific move pattern.
 *
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public class Butterfly extends Animal {

    /**
     * Super constructor for butterfly.
     *
     * @param positiononBoard Position of butterfly.
     */
    public Butterfly(Position positiononBoard) {
        super(positiononBoard);
    }

    /**
     * Default constructor of butterfly.
     */
    public Butterfly() {
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
        Position finalPosition = getPositionOnBoard().next(direction)
                .next(direction).next(direction); //Expected final position
        return moveFlying(board, direction, finalPosition, animals);
    }
}
