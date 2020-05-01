package g54786.humbug.model;

import g54786.humbug.model.animal.Animal;

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
    private LevelStatus levelStatus;
    
    
    /**
     * Setter of remaining moves.
     * 
     * @param remainingMoves 
     */
    @Override
    public void setRemainingMoves(int remainingMoves) {
        this.remainingMoves = remainingMoves;
    }

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
        this.animals = Level.getLevel(level).getAnimals();
        this.remainingMoves = Level.getLevel(level).getNMoves();
        this.board = Level.getLevel(level).getBoard();
        this.levelStatus = LevelStatus.IN_PROGRESS;
    }

    /**
     * Gets the level status to see where the game is at.
     *
     * @return The level status of the game.
     */
    @Override
    public LevelStatus getLevelStatus() {
       return levelStatus;
    }
    
    /**
     * Checks if all animals are on star.
     * 
     * @param animals All animals on board.
     * @return True if all animals are on star, meaning the game is over, 
     * false if not.
     */
    private boolean allOnStar (Animal ... animals){
        boolean allOnStar = true;
        for (Animal animal : animals) {
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
        if (position == null || direction == null){
            throw new IllegalArgumentException();
        }
        if (getLevelStatus() != LevelStatus.IN_PROGRESS) {
            throw new IllegalStateException();
        }
        for (Animal animal : animals) {
            if (animal.getPositionOnBoard().equals(position)) {
                Position nextPosition = animal.move(this.board, direction,
                        this.animals); 
                setRemainingMoves(getRemainingMoves()-1);
                if (allOnStar(animals) ){
                    this.levelStatus = LevelStatus.WIN;
                }
                if (getRemainingMoves() == 0 && !allOnStar(animals)){
                    this.levelStatus = LevelStatus.FAIL;
                }
                if (nextPosition == null) {
                    this.levelStatus = LevelStatus.FAIL;
                    throw new IllegalArgumentException();
                }
            }
        }
    }
}
