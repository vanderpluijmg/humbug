/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54786.humbug.model;

import g54786.humbug.model.Animal.Animal;

/**
 * Responsible to generate a level. A level is a board, animals and a number 
 * of moves.
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public class Level {
    
    private Board board;
    private Animal[] animals;
    private int nMoves;
    /**
     * Private constructor for Level class.
     * @param board Board game.
     * @param animals All animals on board.
     * @param nMoves Number of moves in a level.
     */
    private Level(Board board, Animal[] animals, int nMoves) {
        this.board = board;
        this.animals = animals;
        this.nMoves = nMoves;
    }
    
//    public static Level getLevel(int n){
//    }
    /**
     * Getter for board.
     * @return Board game.
     */
    public Board getBoard() {
        return board;
    }
    /**
     * Getter for animals.
     * @return All animals on board.
     */
    public Animal[] getAnimals() {
        return animals;
    }
    /**
     * Getter for number of moves.
     * @return Number of moves.
     */
    public int getNMoves() {
        return nMoves;
    }
    
    
}
