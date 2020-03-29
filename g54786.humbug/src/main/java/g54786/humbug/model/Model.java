/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54786.humbug.model;

/**
 * This is an interface for Game class.
 * 
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public interface Model {
    /**
     * Getter of board.
     * 
     * @return The board.
     */
    Board getBoard();
    /**
     * Getter of animals.
     * 
     * @return Array of animals.
     */
    Animal[] getAnimals();
    /**
     * Initializes the given level.
     * 
     * @param level Level that will load, in this case level 1.
     */
    void startLevel(int level);
    /**
     * Checks if the level is over, meaning all animals are on square type STAR.
     * 
     * @return True if level is over, false if not.
     */
    boolean levelIsOver();
    /**
     * Moves the animal if its allowed, else throws exception.
     * 
     * @param position Current position of animal.
     * @param direction Direction in which the animal needs to move.
     */
    void move(Position position, Direction direction);
    
}
