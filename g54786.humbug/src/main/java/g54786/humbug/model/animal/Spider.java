package g54786.humbug.model.animal;

import g54786.humbug.model.Board;
import g54786.humbug.model.Direction;
import g54786.humbug.model.Position;
import g54786.humbug.model.SquareType;

/**
 * Makes the spider move. Spider has a specific move pattern.
 *
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public class Spider extends Animal {
    
    /**
     * Super constructor for Spider.
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
        if (board.getSquare(getPositionOnBoard()).hasWall(direction) 
                || board.getSquare(getPositionOnBoard()).hasWall(direction.opposite())){
            setPositionOnBoard(getPositionOnBoard());
            return getPositionOnBoard(); 
        } 
        Position nextPosition = getPositionOnBoard().next(direction);
    
        while (board.isInside(nextPosition)) {
            nextPosition = getPositionOnBoard().next(direction);
            for (Animal animal : animals) {
                if (animal.getPositionOnBoard().equals(nextPosition) && !animal.isOnStar()) {
                    if (board.getSquareType(getPositionOnBoard()) == SquareType.STAR) {
                        setOnStar(true);
                        board.setSquareType(getPositionOnBoard(), SquareType.GRASS);
                        setPositionOnBoard(getPositionOnBoard());
                        return getPositionOnBoard();
                    } else if (board.getSquare(getPositionOnBoard()).hasWall(direction) 
                || board.getSquare(getPositionOnBoard()).hasWall(direction.opposite())){
                        setPositionOnBoard(getPositionOnBoard());
                        return getPositionOnBoard(); 
                    } 
                    setPositionOnBoard(getPositionOnBoard());
                    return getPositionOnBoard();
                }
 
            }
            setPositionOnBoard(nextPosition);
            Position position = getPositionOnBoard();
            nextPosition = nextPosition.next(direction);
        }
        if (board.getSquare(getPositionOnBoard()).hasWall(direction) 
                || board.getSquare(getPositionOnBoard()).hasWall(direction.opposite())){
            if (board.getSquareType(getPositionOnBoard()) == SquareType.STAR) {
                setOnStar(true);
                board.setSquareType(getPositionOnBoard(), SquareType.GRASS);
            }
            setPositionOnBoard(getPositionOnBoard());
            return getPositionOnBoard();
        }
        setPositionOnBoard(null);
        return null;

    }
}