package g54786.humbug.model;

/**
 * All directions in which an animal will be able to move.
 *
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public enum Direction {

    NORTH(-1, 0),
    SOUTH(1, 0),
    EAST(0, 1),
    WEST(0, -1);

    private final int deltaRow;
    private final int deltaColumn;

    /**
     * Constructor of a direction.
     */
    private Direction(int deltaRow, int deltaColumn) {
        this.deltaColumn = deltaColumn;
        this.deltaRow = deltaRow;
    }

    /**
     * Getter of delta row.
     *
     * @return Delta row.
     */
    public int getDeltaRow() {
        return deltaRow;
    }

    /**
     * Getter of delta column
     *
     * @return Delta column.
     */
    public int getDeltaColumn() {
        return deltaColumn;
    }

    /**
     * Gives the opposite of the current direction.
     *
     * @return The opposite of the current direction.
     */
    public Direction opposite() {
        switch (this) {
            case EAST:
                return WEST;
            case WEST:
                return EAST;
            case NORTH:
                return SOUTH;
            default:
                return NORTH;
        }
    }
}
