package g54786.humbug.model.animal;

import g54786.humbug.model.Board;
import g54786.humbug.model.Direction;
import g54786.humbug.model.Position;

/**
 * Makes the ladybird move. Ladybird has specific move pattern.
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public class Ladybird extends Animal {

    /**
     * Super constructor of ladybird.
     * @param positiononBoard Position of ladybird.
     */
    public Ladybird(Position positiononBoard) {
        super(positiononBoard);
    }

    /**
     * Default constructor of ladybird.
     */
    public Ladybird() {
    }
    
    /**
     * Moves Ladybird in given direction.
     * 
     * @param board Board on which the ladybug must move.
     * @param direction Direction in which the ladybug must move.
     * @param animals All animals on the board.
     * @return New position after the ladybug moved.
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        if (board.getSquare(getPositionOnBoard()).hasWall(direction) 
                || board.getSquare(getPositionOnBoard().next(direction)).hasWall
        (direction.opposite())){
            setPositionOnBoard(getPositionOnBoard());
            return getPositionOnBoard(); 
        } 
        if (moveCrawling(board, direction, 1, animals) == null){//On star is off
            setPositionOnBoard(getPositionOnBoard());
            return null;
        }
        return moveCrawling(board, direction, 2, animals); //On star is on
    }
}
