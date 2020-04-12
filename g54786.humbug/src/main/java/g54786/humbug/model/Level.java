/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54786.humbug.model;

import g54786.humbug.model.Animal.Animal;

/**
 *
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public class Level {
    
    private Board board;
    private Animal[] animals;
    private int nMoves;

    public Level(Board board, Animal[] animals, int nMoves) {
        this.board = board;
        this.animals = animals;
        this.nMoves = nMoves;
    }
    
    //public static Level getLevel(int n){
        
    //}

    public Board getBoard() {
        return board;
    }

    public Animal[] getAnimals() {
        return animals;
    }

    public int getNMoves() {
        return nMoves;
    }
    
    
}
