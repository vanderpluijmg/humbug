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
public abstract class Game implements Model {
    //Board board = new Board(square);
    //Animal[] animal = new Animal;
    
    public void startLevel (Board board, Animal[] animal){
        Board.getInitialBoard();
        
    }
    /**
     * Checks if the level is over, meaning all animals are on square type STAR.
     * @param board level board.
     * @param animal All animals on board.
     * @return True or false.
     */
    public boolean levelIsOVer (Board board, Animal[] animal){
        boolean levelIsOver = true;
        for (Animal animals : animal){
            if (animals.isOnStar() == false){
                levelIsOver = false;
            }
        }
        return levelIsOver;
        
    }
    /**
     * Move the animal if its allowed.
     * @param board level board
     * @param direction direction in which the animal needs to move.
     * @param animal all animals on board.
     */
    public void move (Board board, Direction direction, Animal[] animal){
        if (board == null || direction == null){
            throw new IllegalArgumentException();
        }
        
        
            
        }
    }
    
    
    
    

