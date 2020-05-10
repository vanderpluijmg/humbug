package g54786.humbug.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import g54786.humbug.model.animal.Animal;
import java.io.IOException;

/**
 * Responsible to generate a level. A level is a board, animals and a number of
 * moves.
 *
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public class Level {

    private Board board;
    private Animal[] animals;
    private int nMoves;

    /**
     * Default constructor of level
     */
    public Level() {
    }

    /**
     * Reads desired level with the help of Json object mapper.
     *
     * @param n Level to read.
     * @return Chosen level.
     */
    private static Level readLevel(int n) {
        try {
            var objectMapper = new ObjectMapper();
            var inputStream = Level.class.getResourceAsStream("/data/level-" + n
                    + ".json");
            var level = objectMapper.readValue(inputStream, Level.class);
            return level;
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    /**
     * Getter for level.
     *
     * @param n Level to get.
     * @return Level.
     */
    public static Level getLevel(int n) {
        return readLevel(n);
    }

    /**
     * Private constructor for Level class.
     *
     * @param board Board game.
     * @param animals All animals on board.
     * @param nMoves Number of moves in a level.
     */
    private Level(Board board, Animal[] animals, int nMoves) {
        this.board = board;
        this.animals = animals;
        this.nMoves = nMoves;
    }

    /**
     * Setter for number of moves of a level.
     *
     * @param nMoves Number of moves.
     */
    public void setnMoves(int nMoves) {
        this.nMoves = nMoves;
    }

    /**
     * Getter for board.
     *
     * @return Board game.
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Getter for animals.
     *
     * @return All animals on board.
     */
    public Animal[] getAnimals() {
        return animals;
    }

    /**
     * Getter for number of moves.
     *
     * @return Number of moves.
     */
    public int getNMoves() {
        return nMoves;
    }
}
