package g54786.humbug.model;

import g54786.humbug.model.Animal.Snail;
import g54786.humbug.model.Animal.Animal;

/**
 * All the elements needed for the game.
 *
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public abstract class Game implements Model {

    private Board board;
    private Animal[] animals;
    private int remainingMoves;
    private int currentLevel;

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

    @Override
    public int getRemainingMoves() {
        return remainingMoves;
    }

    /**
     * Initializes the given level.
     *
     * @param level Level that will load, in this case level 1.
     */
    @Override
    public void startLevel(int level) {
        board = Board.getInitialBoard();
        animals = new Animal[]{new Snail(new Position(0, 0)) {},};
    }

    /**
     * Moves the animal if its allowed, else throws exception.
     *
     * @param position Current position of animal.
     * @param direction Direction in which the animal needs to move.
     */
    @Override
    public void move(Position position, Direction direction) {
        if (this.board == null || this.animals == null) {
            throw new IllegalArgumentException();
        }
        for (Animal animal : animals) {
            if (animal.getPositionOnBoard().equals(position)) {
                Position nextPosition = animal.move(this.board, direction,
                        this.animals);
                if (nextPosition == null) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

}
