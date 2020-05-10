package g54786.humbug.model.animal;

import g54786.humbug.model.Board;
import g54786.humbug.model.Direction;
import g54786.humbug.model.Position;

/**
 * Makes the bumblebee move. Bumblebee has a specific move pattern.
 *
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public class Bumblebee extends Animal {

    /**
     * Super constructor of bumblebee. Bumblebee has specific move pattern.
     *
     * @param positiononBoard Position of bumblebee.
     */
    public Bumblebee(Position positiononBoard) {
        super(positiononBoard);
    }

    /**
     * Default constructor of bumblebee.
     */
    public Bumblebee() {
    }

    /**
     * Moves bumblebee in given direction.
     *
     * @param board Board on which the bumblebee must move.
     * @param direction Direction in which the bumblebee must move.
     * @param animals All animals on the board.
     * @return New position after the bumblebee moved.
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        Position finalPosition = getPositionOnBoard().next(direction)
                .next(direction); //Expected final position.
        return moveFlying(board, direction, finalPosition, animals);
    }
}
