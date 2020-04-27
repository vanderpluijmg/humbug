package g54786.humbug.model;

import java.util.Objects;

/**
 * Position of a square. Position is composed of a row and column value.
 *
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public class Position {

    private int row; 
    private int column;

    /**
     * Constructor of a position
     *
     * @param row Row coordinates of position.
     * @param column Column coordinates of position.
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }
    
    /**
     * Default constructor of position.
     */
    public Position(){
    }

    /**
     * Getter of row.
     *
     * @return Row coordinates.
     */
    public int getRow() {
        return row;
    }

    /**
     * Getter of column.
     *
     * @return Column coordinates.
     */
    public int getColumn() {
        return column;
    }

    /**
     * Generates hash code to have the possibility to test if two positions are
     * the same.
     *
     * @return The generated hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    /**
     * Tests if the current object is equal to the object given in parameters.
     *
     * @param object Objet wished to compare to current object.
     * @return True if they are equal, false if not.
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        final Position other = (Position) object;
        if (this.row != other.row) {
            return false;
        }
        return this.column == other.column;
    }

    /**
     * Gives the position next to the current position in the given direction.
     *
     * @param direction Direction in which to go.
     * @return New position in the given direction.
     */
    public Position next(Direction direction) {
        Position position = new Position(getRow()
                + direction.getDeltaRow(), getColumn()
                + direction.getDeltaColumn());
        return position;
    }

    /**
     * For display purposes.
     *
     * @return Position in text.
     */
    @Override
    public String toString() {
        return "position :" + "(" + row + "," + column + ")";
    }

}
