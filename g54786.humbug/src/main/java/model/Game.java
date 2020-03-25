/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * All the elements needed for the game.
 *
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public abstract class Game implements Model {

    private Board board;
    private Animal[] animals;
    /**
     * Getter of board.
     * 
     * @return The board.
     */
    @Override
    public Board getBoard() {
        return board;
    }
    /**
     * Getter of animals.
     * @return Array of animals.
     */
    @Override
    public Animal[] getAnimals() {
        return animals;
    }

    /**
     * Initializes the given level.
     *
     * @param level Level that will load, in this case level 1.
     */
    @Override
    public void startLevel(int level) {
        board = Board.getInitialBoard();
        animals = new Animal[]{new Spider(new Position(0, 1)) {}};
    }

    /**
     * Checks if the level is over, meaning all animals are on square type STAR.
     *
     * @return True if level is over, false if not.
     */
    @Override
    public boolean levelIsOver() {
        if (board == null || animals == null) {
            throw new IllegalArgumentException();
        }
        boolean levelIsOver = true;
        for (Animal allAnimals : animals) {
            if (allAnimals.isOnStar() == false) {
                levelIsOver = false;
            }
        }
        return levelIsOver;

    }

    /**
     * Moves the animal if its allowed, else throws exception.
     *
     * @param position Current position of animal.
     * @param direction direction in which the animal needs to move.
     */
    @Override
    public void move(Position position, Direction direction) {
        if (board == null || direction == null) {
            throw new IllegalArgumentException();
        }
        int index = 0;
        while (index < animals.length) {
            if (position.equals(getAnimals()[index].getPositionOnBoard())
                    || getAnimals()[index].getPositionOnBoard() == null){
                throw new IllegalArgumentException();
            }
            else getAnimals()[index].move(board, direction, animals);
            index++;
        }
    }
}
