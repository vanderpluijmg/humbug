package g54786.humbug.model.Animal;

import g54786.humbug.model.Board;
import g54786.humbug.model.Direction;
import g54786.humbug.model.Position;

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
    boolean containsAWall(Position position,Board board, Direction direction){
        boolean containsWall = false;
        
        if (board.getSquare(position).hasWall(direction)
                    || board.getSquare(position.next(direction))
                            .hasWall(direction.opposite())) {
                setPositionOnBoard(getPositionOnBoard());
                containsWall = true;
            }
        return containsWall;
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
