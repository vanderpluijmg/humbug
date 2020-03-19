/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;



/**
 * Square on the board.
 * A square is or grass or star.
 * @author router
 */
public class Square {
    private final SquareType type;
    
    /**
     * Constructor of square on board.
     * @param type Square is grass or star.
     */
    public Square (SquareType type) {
        this.type = type;
    }
    
    /**
     * Getter of Square type.
     * @return type of square.
     */
    public SquareType getType() {
        return type;
    }
  
}
