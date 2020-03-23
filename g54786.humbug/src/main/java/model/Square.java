/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Square on the board. A square is or grass or star.
 *
 * @author router
 */
public class Square {

    private SquareType type;

    /**
     * Constructor of square on board.
     *
     * @param type Square is grass or star.
     */
    public Square(SquareType type) {
        this.type = type;
    }
    /**
     * Setter of SquareType.
     * @param type Type of square you want.
     * @return 
     */
    public SquareType setType(SquareType type) {
        this.type = type;
        return this.type;
    }

    /**
     * Getter of Square type.
     *
     * @return type of square.
     */
    public SquareType getType() {
        return type;
    }

}
