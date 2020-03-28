/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54786.humbug.model;

/**
 * Position of a square. Position is composed of a row and column value.
 *
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public class Position {

    private final int row; //Final because a row does not change.
    private final int column; //Final because a column does not change.

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
        int hash = 5;
        hash = 23 * hash + this.row;
        hash = 23 * hash + this.column;
        return hash;
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
        if (this.column != other.column) {
            return false;
        }
        return true;
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
     * @return Position in text. 
     */
    @Override
    public String toString() {
        return "position :" + "(" + row + "," + column + ")";
    }

}
