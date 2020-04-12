package g54786.humbug.model.Animal;

import g54786.humbug.model.Board;
import g54786.humbug.model.Direction;
import g54786.humbug.model.Position;
import g54786.humbug.model.SquareType;

/**
 * Makes the snail move. Snail has a specific move pattern.
 *
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public abstract class Snail extends Animal {
    /**
     * Constructor for Snail class.
     * @param positionOnBoard Position on board.
     */
    public Snail(Position positionOnBoard) {
        super(positionOnBoard);
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
        
        Position initPosition = getPositionOnBoard();
        Position nextPosition = initPosition.next(direction);
        while (board.isInside(nextPosition)) {
            for (Animal animal : animals) {
                if (animal.getPositionOnBoard().equals(nextPosition)) {
                    setPositionOnBoard(initPosition);
                    return initPosition;
                }
            }
            if (board.getSquareType(nextPosition) == SquareType.STAR) {
                setOnStar(true);
                board.setSquareType(nextPosition, SquareType.GRASS);
                setPositionOnBoard(nextPosition);
                return nextPosition;
            } else if (board.getSquare(nextPosition).hasWall(direction) 
                    && board.getSquare(nextPosition.next(direction))
                            .hasWall(direction.opposite())){
                setPositionOnBoard(initPosition);
                return initPosition;
                
            }else  {
                setPositionOnBoard(nextPosition);
                return nextPosition;
            } 
        }
        setPositionOnBoard(null);
        return null;
    }

}
