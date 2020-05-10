package g54786.humbug.model.animal;

import g54786.humbug.model.Board;
import g54786.humbug.model.Direction;
import g54786.humbug.model.Position;

/**
 * Makes the spider move. Spider has a specific move pattern.
 *
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public class Spider extends Animal {

    /**
     * Super constructor for Spider.
     *
     * @param positiononBoard Position on board of spider.
     */
    public Spider(Position positiononBoard) {
        super(positiononBoard);
    }

    /**
     * Default constructor for spider
     */
    public Spider() {
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
        return moveWalking(board, direction, animals);
    }
}
