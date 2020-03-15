/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Square position.
 * @author router
 */
public class Position {
    private final int row;
    private final int column;
    
    /**
     * Position constructor.
     * @param row in which a square is.
     * @param column in which is square is.
     */
    public Position (int row, int column){
        this.row = row;
        this.column = column;
    }

    /**
     * Row getter.
     * @return 
     */
    public int getRow() {
        return row;
    }

    /**
     * Column getter.
     * @return 
     */
    public int getColumn() {
        return column;
    }

    /**
     * Hash code to test if positions are equal to each other.
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.row;
        hash = 23 * hash + this.column;
        return hash;
    }
    /**
     * Tests if two square are at the same position.
     * @param obj Square position
     * @return True or False.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        if (this.row != other.row) {
            return false;
        }
        if (this.column != other.column) {
            return false;
        }
        return true;
    }
    
    
    
}
