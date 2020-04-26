package g54786.humbug.model.animal;

import g54786.humbug.model.Board;
import g54786.humbug.model.Direction;
import g54786.humbug.model.Position;

/**
 * Makes the snail move. Snail has a specific move pattern.
 *
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public class Snail extends Animal {

    /**
     * Constructor for Snail class.
     *
     * @param positionOnBoard Position on board.
     */
    public Snail(Position positionOnBoard) {
        super(positionOnBoard);
    }

    public Snail(){
    }

    /**
     * Moves snail in given direction.
     *
     * @param board Board on which the snail must move.
     * @param direction Direction in which the snail must move.
     * @param animals All animals on the board.
     * @return New position after the snail moved.
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        if (board.getSquare(getPositionOnBoard()).hasWall(direction) 
                || board.getSquare(getPositionOnBoard()).hasWall(direction.opposite())){
            setPositionOnBoard(getPositionOnBoard());
            return getPositionOnBoard(); 
        } 
        return moveCrawling(board, direction, 2, animals);
    }
}