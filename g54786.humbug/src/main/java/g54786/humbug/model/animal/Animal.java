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
 * Animals know where they are on the board but they don't know if they are on
 * square type STAR.
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
    @Type(value = Spider.class),
    })

public abstract class Animal {

    private Position positionOnBoard;
    private boolean onStar;

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
    Position moveFlying(Board board, Direction direction, Position finalPosition, Animal... animals) {
        try {
            board.getSquareType(finalPosition);
        } catch (IllegalArgumentException e) {
            setPositionOnBoard(null);
            return null;
        }
        for (Animal animal : animals) {
            if (animal.getPositionOnBoard().equals(finalPosition)) {
                if (!board.isInside(finalPosition.next(direction))) {
                    setPositionOnBoard(null);
                    return null;
                }
                setPositionOnBoard(finalPosition.next(direction));
                if (board.getSquareType(getPositionOnBoard())
                        == SquareType.STAR) {
                    setOnStar(true);
                    board.setSquareType(getPositionOnBoard(),
                            SquareType.GRASS);
                }
                finalPosition = finalPosition.next(direction);
            }
        }
        if (board.getSquareType(finalPosition) == SquareType.STAR) {
            setOnStar(true);
            setPositionOnBoard(finalPosition);
            board.setSquareType(finalPosition, SquareType.GRASS);
            return finalPosition;
        } else {
            setPositionOnBoard(finalPosition);
            return finalPosition;
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

        while (board.isInside(nextPosition)) {
            for (Animal animal : animals) {
                while (animal.getPositionOnBoard().equals(nextPosition)) {
                    if (checkForStar(board, getPositionOnBoard())) {
                        starProcedure(board, getPositionOnBoard());
                    }
                    nextPosition = nextPosition.next(direction);
                    setPositionOnBoard(nextPosition);
                }
            }
            setPositionOnBoard(nextPosition);
            return nextPosition;
        }
        if (checkForStar(board, getPositionOnBoard())) {
            starProcedure(board, getPositionOnBoard());
        }

        setPositionOnBoard(null);
        return null;
    }

    /**
     * Moves a crawling animal
     *
     * @param index Turns on or off the ability to set the animal on star and
     * switch the square type. 2 means it's on.
     * @param board Board game.
     * @param direction Direction in which to go.
     * @param animals All animals on board.
     * @return New position of the animal.
     */
    Position moveCrawling(Board board, Direction direction, int index,
            Animal... animals) {
        Position nextPosition = getPositionOnBoard().next(direction);
        while (board.isInside(nextPosition)) {
            for (Animal animal : animals) {
                if (animal.getPositionOnBoard().equals(nextPosition)) {
                    if (checkForStar(board, getPositionOnBoard()) && index == 2) {
                        starProcedure(board, getPositionOnBoard());
                    }
                    setPositionOnBoard(getPositionOnBoard());
                    return getPositionOnBoard();
                }
            }
            if (checkForWall(board, direction)) {
                setPositionOnBoard(getPositionOnBoard());
                return getPositionOnBoard();
            }
            setPositionOnBoard(nextPosition);
            if (checkForStar(board, getPositionOnBoard()) && index == 2) {
                starProcedure(board, getPositionOnBoard());
            }
            return getPositionOnBoard();
        }
        setPositionOnBoard(null);
        return null;
    }

    /**
     * Check for a wall in the given direction.
     *
     * @param board Board game.
     * @param direction Direction in which to check.
     * @return True if there is a wall, false if not.
     */
    private boolean checkForWall(Board board, Direction direction) {
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
    private boolean checkForStar(Board board, Position position) {
        boolean SquareIsStar = false;
        if (board.getSquareType(position) == SquareType.STAR) {
            SquareIsStar = true;
        }
        return SquareIsStar;
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
