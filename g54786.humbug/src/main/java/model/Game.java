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
        return this.board;
    }

    /**
     * Getter of animals.
     *
     * @return Array of animals.
     */
    @Override
    public Animal[] getAnimals() {
        return this.animals;
    }

    /**
     * Initializes the given level.
     *
     * @param level Level that will load, in this case level 1.
     */
    @Override
    public void startLevel(int level) {
        board = Board.getInitialBoard();
        animals = new Animal[]{new Spider(new Position(0, 0)) {
        }};
        //Position starPosition = new Position(2,2);
    }

    /**
     * Checks if the level is over, meaning all animals are on square type STAR.
     *
     * @return True if level is over, false if not.
     */
    @Override
    public boolean levelIsOver() {
        if (this.board == null || animals == null) {
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
        if (this.board == null || this.animals == null) {
            throw new IllegalArgumentException();
        }
        for (Animal animal : animals) {
            if (animal.getPositionOnBoard().equals(position)) {
                Position nextPosition = animal.move(this.board, direction, this.animals);
                if (nextPosition == null) {
                    System.out.println("Null position");
                }
            }
        }
    }

}
