package g54786.humbug.model.animal;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import g54786.humbug.model.Board;
import g54786.humbug.model.Direction;
import g54786.humbug.model.Position;
import g54786.humbug.model.SquareType;

/**
 * Animals know where they are on the board but they don't know wether they are
 * on square type star or not.
 *
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
@JsonTypeInfo(use = Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
    @Type(value = Bumblebee.class),
    @Type(value = Grasshopper.class),
    @Type(value = Ladybird.class),
    @Type(value = Snail.class),
    @Type(value = Spider.class),})

public abstract class Animal {

    private Position positionOnBoard;
    private boolean onStar;

    /**
     * Default constructor of animal.
     */
    public Animal() {
    }

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

    /**
     * Moves a flying animal
     *
     * @param board Board game.
     * @param direction Direction in which to go.
     * @param animals All animals on the board.
     * @return New position of the animal.
     */
    Position moveFlying(Board board, Direction direction, Position finalPosition,
            Animal... animals) {
        while (!emptyCase(board, finalPosition, animals)) {
            finalPosition = finalPosition.next(direction);
        }
        setPositionOnBoard(finalPosition);
        if (board.isInside(getPositionOnBoard())) {
            if (containsStar(board, getPositionOnBoard())) {
                starProcedure(board, getPositionOnBoard());
            }
            return getPositionOnBoard();
        } else {
            setPositionOnBoard(null);
            return null;
        }
    }

    /**
     * Moves a jumping animal.
     *
     * @param board Board game
     * @param direction Direction in which to go.
     * @param animals All animals on board.
     * @return New position of the animal.
     */
    Position moveJumping(Board board, Direction direction, Animal... animals) {
        Position nextPosition = getPositionOnBoard().next(direction);
        while (!emptyCase(board, nextPosition, animals)) {
            nextPosition = nextPosition.next(direction);
        }
        setPositionOnBoard(nextPosition);
        if (board.isInside(getPositionOnBoard())) {
            if (containsStar(board, getPositionOnBoard())) {
                starProcedure(board, getPositionOnBoard());
            }
            return getPositionOnBoard();
        } else {
            setPositionOnBoard(null);
            return null;
        }
    }

    /**
     * Moves a crawling animal
     *
     * @param index Turns on or off the ability to set the animal on star and
     * switch the square type. 1 means it's on.
     * @param board Board game.
     * @param direction Direction in which to go.
     * @param animals All animals on board.
     * @return New position of the animal.
     */
    Position moveCrawling(Board board, Direction direction, int index,
            Animal... animals) {
        Position nextPosition = getPositionOnBoard().next(direction);
        if (!board.isInside(nextPosition)) {
            if (board.getSquare(getPositionOnBoard()).hasWall(direction)) {
                setPositionOnBoard(getPositionOnBoard());
                return getPositionOnBoard();
            }
            setPositionOnBoard(null);
            return null;
        } else {
            if (emptyCase(board, nextPosition, animals)
                    && !containsWall(board, direction)) {
                setPositionOnBoard(nextPosition);
            }
            if (containsStar(board, getPositionOnBoard()) && index == 1) {
                starProcedure(board, getPositionOnBoard());
            }
            return getPositionOnBoard();
        }
    }

    /**
     * Moves a walking animal.
     *
     * @param board Board game.
     * @param direction Direction in which to go.
     * @param animals All animals on board.
     * @return New position of the animal.
     */
    Position moveWalking(Board board, Direction direction, Animal... animals) {
        Position nextPosition = getPositionOnBoard().next(direction);
        if (!board.isInside(nextPosition)) {
            if (board.getSquare(getPositionOnBoard()).hasWall(direction)) {
                setPositionOnBoard(getPositionOnBoard());
                return getPositionOnBoard();
            }
            setPositionOnBoard(null);
            return null;
        } else {
            while (emptyCase(board, nextPosition, animals)
                    && !containsWall(board, direction)) {
                setPositionOnBoard(nextPosition);
                nextPosition = nextPosition.next(direction);
                if (!board.isInside(nextPosition)) {
                    if (board.getSquare(getPositionOnBoard()).hasWall(direction)){
                        setPositionOnBoard(getPositionOnBoard());
                        return getPositionOnBoard();
                    }
                    setPositionOnBoard(null);
                    return null;
                }
            }
            if (containsStar(board, getPositionOnBoard())) {
                starProcedure(board, getPositionOnBoard());
            }
            return getPositionOnBoard();
        }
    }

    /**
     * Check for a wall in the given direction.
     *
     * @param board Board game.
     * @param direction Direction in which to check.
     * @return True if there is a wall, false if not.
     */
    private boolean containsWall(Board board, Direction direction) {
        boolean wall = false;
        if (board.getSquare(getPositionOnBoard()).hasWall(direction)
                || board.getSquare(getPositionOnBoard().next(direction))
                        .hasWall(direction.opposite())) {
            wall = true;
        }
        return wall;
    }

    /**
     * Expected procedure if animal is on star square type.
     *
     * @param board Board game.
     * @param position Position to check.
     * @return Position of the animal.
     */
    private Position starProcedure(Board board, Position position) {
        setPositionOnBoard(position);
        setOnStar(true);
        board.setSquareType(position, SquareType.GRASS);
        return position;
    }

    /**
     * Checks if the positions contains a square type star.
     *
     * @param board Board game.
     * @param position Position to check.
     * @return True if it contains a star, false if not.
     */
    private boolean containsStar(Board board, Position position) {
        if (position == null) {
            return false;
        }
        boolean SquareIsStar = false;
        if (board.getSquareType(position) == SquareType.STAR) {
            SquareIsStar = true;
        }
        return SquareIsStar;
    }

    /**
     * Checks if the case is empty meaning there is no animal on it.
     *
     * @param board Board game.
     * @param position Position to check for empty square.
     * @param animals All animals on board.
     * @return True if square is empty, false if not.
     */
    private boolean emptyCase(Board board, Position position, Animal... animals) {
        boolean empty = true;
        for (Animal animal : animals) {
            if (animal.getPositionOnBoard().equals(position) &&
                    !animal.isOnStar()) {
                empty = false;
            }
        }
        return empty;
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
