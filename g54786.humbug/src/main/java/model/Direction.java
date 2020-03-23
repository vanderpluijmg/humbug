/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Direction in which an animal will be able to move.
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public enum Direction {
    NORTH(-1,0), SOUTH(1,0), EAST(0,1), WEST(0,-1);
    
    private final int deltaRow;
    private final int deltaColumn;
    
    /**
     * Constructor for direction.
     */
    private Direction(int deltaRow, int deltaColumn) {
        this.deltaColumn = deltaColumn;
        this.deltaRow = deltaRow;
        
        
    }
    
    /**
     * Getter for delta row
     * @return delta row.
     */
    public int getDeltaRow() {
        return deltaRow;
    }

    /**
     * Getter for delta column
     * @return delta column.
     */
    public int getDeltaColumn() {
        return deltaColumn;
    }
    
    
    
}
