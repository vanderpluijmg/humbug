/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * All the elements needed for the game.
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public abstract class Game implements Model {
    
    private Board board;
    private Animal[] animals;
    /**
     * Starts the first level.
     * @param level
     */
    @Override
    public void startLevel (int level){
        board = Board.getInitialBoard();
        animals = new Animal[] {new Snail(new Position(0,0)) {}};
    }
    /**
     * Checks if the level is over, meaning all animals are on square type STAR.
     * @return True or false.
     */
    @Override
    public boolean levelIsOver(){
        if (board == null || animals == null){
            throw new IllegalArgumentException();
        }
        boolean levelIsOver = true;
        for (Animal animals : animals){
            if (animals.isOnStar() == false){
                levelIsOver = false;
            }
        }
        return levelIsOver;
        
    }
    /**
     * Move the animal if its allowed.
     * @param position
     * @param direction direction in which the animal needs to move.
     */
    @Override
        public void move(Position position, Direction direction){
        if (board == null || direction == null){
            throw new IllegalArgumentException();
        }
        int i = 0;
        while (i <animals.length) {
            position = getAnimals()[i].move(board, direction, animals);
            if (getAnimals()[i].getPositionOnBoard()==null){
                i++;
            } else {
                System.err.println("L'animal est betom");
        }
            i++;    
        }
    }
}
    
    
    
    

