/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


/**
 * 
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public abstract class Animal {
    private Position positionOnBoard;
    private boolean onStar;
    /**
     * Animal constructor.
     * @param positiononBoard Position on board of animal;
     */
    public Animal (Position positiononBoard){
        this.onStar = false;
        this.positionOnBoard = positiononBoard;
    }
    
    /**
     * Setter for position on board of animal.
     * @param positionOnBoard new position on board
     */
    public void setPositionOnBoard(Position positionOnBoard) {
        this.positionOnBoard = positionOnBoard;
    }
    /**
     * Setter for animal on star
     * @param onStar if animal is on star or not.
     */
    public void setOnStar(boolean onStar) {
        this.onStar = onStar;
    }
    /**
     * getter for animal on star.
     * @return current state of on star.
     */
    public boolean isOnStar() {
        return onStar;
    }
    /**
     * Getter for position on board of animal.
     * @return current position on board.
     */
    public Position getPositionOnBoard() {
        return positionOnBoard;
    }
    public abstract Position move (Board board, Direction direction, 
            Animal... animals);
    
    
    
    
}
