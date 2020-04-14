package g54786.humbug.model.Animal;

import g54786.humbug.model.Board;
import g54786.humbug.model.Board;
import g54786.humbug.model.Direction;
import g54786.humbug.model.Direction;
import g54786.humbug.model.Position;
import g54786.humbug.model.Position;
import g54786.humbug.model.Square;

/**
 * Animals know where they are on the board but they don't know if they are on
 * square type STAR.
 *
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public abstract class Animal {

    private Position positionOnBoard;
    private boolean onStar;

    /**
     * Constructor for an animal.
     *
     * @param positiononBoard Position on board of animal;
     */
    public Animal(Position positiononBoard) {
        this.onStar = false;
        this.positionOnBoard = positiononBoard;
    }

    /**
     * Setter for position on board of animal.
     *
     * @param positionOnBoard New position on board
     */
    public void setPositionOnBoard(Position positionOnBoard) {
        this.positionOnBoard = positionOnBoard;
    }

    /**
     * Setter for animal on star.
     *
     * @param onStar If animal is on star or not.
     */
    public void setOnStar(boolean onStar) {
        this.onStar = onStar;
    }

    /**
     * Getter for animal on star.
     *
     * @return Current state of on star.
     */
    public boolean isOnStar() {
        return onStar;
    }

    /**
     * Getter for position on board of animal.
     *
     * @return current position on board.
     */
    public Position getPositionOnBoard() {
        return positionOnBoard;
    }
    Position moveOneFlying (Direction direction, Position position, Board board, 
            Animal ... animals){
        Position nextPosition = position.next(direction);
            for (Animal animal : animals){
                if (!board.isInside(nextPosition)){
                    setPositionOnBoard(null);
                    return null;
                } else if (animal.getPositionOnBoard().equals(nextPosition)){
                    setPositionOnBoard(positionOnBoard);
                    return nextPosition.next(direction);
                }
                
            }
            setPositionOnBoard(nextPosition);
            return nextPosition;          
        }

    /**
     * Allows the animal to move on the board in different directions.
     *
     * @param board Board game.
     * @param direction Direction in which the animal will move.
     * @param animals All animals present on the board.
     * @return New position of the moved animal.
     */
    public abstract Position move(Board board, Direction direction,
            Animal... animals);

}
