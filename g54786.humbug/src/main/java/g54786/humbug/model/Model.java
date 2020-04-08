package g54786.humbug.model;

import g54786.humbug.model.Animal.Animal;

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
