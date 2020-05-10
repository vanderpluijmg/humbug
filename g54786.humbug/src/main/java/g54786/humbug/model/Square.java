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

    /**
     * Default constructor of square.
     */
    public Square() {
    }
    
    /**
     * Setter of a wall to the north.
     * 
     * @param northWall Sets a wall if true.
     */
    public void setNorthWall(boolean northWall) {
        this.northWall = northWall;
    }

    /**
     * Setter of a wall to the west.
     * 
     * @param westWall Sets a wall if true.
     */
    public void setWestWall(boolean westWall) {
        this.westWall = westWall;
    }

    /**
     * Setter of a wall to the east.
     * 
     * @param eastWall Sets a wall if true.
     */
    public void setEastWall(boolean eastWall) {
        this.eastWall = eastWall;
    }
    
    /**
     * Setter of a wall to the south.
     * 
     * @param southWall Sets a wall if true.
     */
    public void setSouthWall(boolean southWall) {
        this.southWall = southWall;
    }

    /**
     * Getter of north wall.
     *
     * @return status of north wall
     */
    public boolean isNorthWall() {
        return northWall;
    }

    /**
     * Getter of west wall.
     *
     * @return status of west wall
     */
    public boolean isWestWall() {
        return westWall;
    }

    /**
     * Getter of east wall.
     *
     * @return status of east wall.
     */
    public boolean isEastWall() {
        return eastWall;
    }

    /**
     * Getter of south wall.
     *
     * @return status of south wall.
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
