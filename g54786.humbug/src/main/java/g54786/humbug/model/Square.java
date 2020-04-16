package g54786.humbug.model;

/**
 * Square on the board. A square is or grass or star. A square does not know its
 * location on the board.
 *
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public class Square {

    private SquareType type;
    private boolean northWall;
    private boolean westWall;
    private boolean eastWall;
    private boolean southWall;

    /**
     * Constructor of square on board.
     *
     * @param type Square is grass or star.
     */
    public Square(SquareType type) {
        this.type = type;
        this.eastWall = false;
        this.northWall = false;
        this.southWall = false;
        this.westWall = false;
    }

    public void setNorthWall(boolean northWall) {
        this.northWall = northWall;
    }

    public void setWestWall(boolean westWall) {
        this.westWall = westWall;
    }

    public void setEastWall(boolean eastWall) {
        this.eastWall = eastWall;
    }

    public void setSouthWall(boolean southWall) {
        this.southWall = southWall;
    }

    /**
     * Getter of north wall
     *
     * @return status of north wall
     */
    public boolean isNorthWall() {
        return northWall;
    }

    /**
     * Getter of west wall
     *
     * @return
     */
    public boolean isWestWall() {
        return westWall;
    }

    /**
     * Getter of east wall
     *
     * @return
     */
    public boolean isEastWall() {
        return eastWall;
    }

    /**
     * Getter of south wall
     *
     * @return
     */
    public boolean isSouthWall() {
        return southWall;
    }

    /**
     * Setter of SquareType.
     *
     * @param type Type of square to set.
     * @return Set square type.
     */
    public SquareType setType(SquareType type) {
        this.type = type;
        return this.type;
    }

    /**
     * Getter of Square type.
     *
     * @return Type of square.
     */
    public SquareType getType() {
        return type;
    }
    /**
     * Checks if the direction has a wall.
     * 
     * @param direction Direction to check for wall.
     * @return True if it does have a wall, false if not. 
     */
    public boolean hasWall(Direction direction) {
        switch (direction) {
            case SOUTH:
                return isSouthWall();
            case EAST:
                return isEastWall();
            case NORTH:
                return isNorthWall();
            default:
                return isWestWall();
        }
    }
}
