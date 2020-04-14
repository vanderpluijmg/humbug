package g54786.humbug.model;

import g54786.humbug.model.Animal.Animal;
import g54786.humbug.model.Animal.Snail;

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
    /**
     * Getter of remaining moves.
     * 
     * @return Remaining number of moves.
     */
    @Override
    public int getRemainingMoves() {
        return this.remainingMoves;
    }
    /**
     * Getter for current level.
     * 
     * @return Level.
     */
    public int getCurrentLevel() {
        return this.currentLevel;
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
    @Override
    public LevelStatus getLevelStatus(){
        for (Animal animal : animals){
            if (allOnStar(animals)){
                return LevelStatus.WIN;
            } else if (animal.getPositionOnBoard() == null){
                return LevelStatus.FAIL;
            } else if (animal.isOnStar()){ //ADJUST DIFFERENCE BETWEEN
                return LevelStatus.NOT_STARTED;
            } else {
                return LevelStatus.IN_PROGRESS;
            }
        }
        return null;
    }   
    private boolean allOnStar (Animal ... animals){
        boolean allOnStar = true;
        for (Animal animal : animals){
            if (!animal.isOnStar()){
                allOnStar = false;
            }
        }
        return allOnStar;
    }

    /**
     * Moves the animal if its allowed, else throws exception.
     *
     * @param position Current position of animal.
     * @param direction Direction in which the animal needs to move.
     */
    @Override
    public void move(Position position, Direction direction) {
        if (getLevelStatus() != LevelStatus.IN_PROGRESS) {
            throw new IllegalStateException();
        }
        for (Animal animal : animals) {
            if (animal.getPositionOnBoard().equals(position)) {
                Position nextPosition = animal.move(this.board, direction,
                        this.animals);
                this.remainingMoves = getRemainingMoves() -1;
                if (nextPosition == null) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }
    

}
