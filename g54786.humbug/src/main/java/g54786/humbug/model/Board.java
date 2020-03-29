package g54786.humbug.model;

/**
 * Board game is constituted of squares. The board does not know if or which
 * animals are on it.
 *
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public class Board {

    /**
     * Initializes initial board, level 1.
     *
     * @return Level 1 board.
     */
    public static Board getInitialBoard() {
        Square grass = new Square(SquareType.GRASS);
        Square Star = new Square(SquareType.STAR);
        Square[][] lvl1 = {{grass, grass, null}, {null, grass, grass},
        {null, null, Star}};
        Board board = new Board(lvl1);
        return board;
    }

    private final Square squares[][];

    /**
     * Constructor for board class.
     *
     * @param square 2D array, board game.
     */
    Board(Square[][] square) {
        this.squares = square;
    }

    /**
     * Checks if given position is on the board game or not.
     *
     * @param position Position to check.
     * @return True if exists, false if not.
     */
    public boolean isInside(Position position) {
        boolean isInside = true;
        if (position == null) {
            throw new IllegalArgumentException();
        }
        if (position.getRow() >= this.getNbRow() //Checks if row is bigger than size. 
                || position.getColumn() >= this.getNbColumn() //Checks if column is bigger than size.
                || position.getRow() < 0 || position.getColumn() < 0) {
            isInside = false;
        } else if (squares[position.getRow()][position.getColumn()] == null) {
            isInside = false;
        }
        return isInside;
    }

    /**
     * Gets square type of given position.
     *
     * @param position Position to check.
     * @return Square type of given position
     */
    public SquareType getSquareType(Position position) {
        if (squares[position.getRow()][position.getColumn()] == null) {
            throw new IllegalArgumentException();
        }
        return squares[position.getRow()][position.getColumn()].getType();
    }

    /**
     * Sets the square to the desired square type.
     *
     * @param position Position of the square.
     * @param type Square type to which it needs to be set.
     * @return The set square type.
     */
    public SquareType setSquareType(Position position, SquareType type) {
        if (squares[position.getRow()][position.getColumn()] == null) {
            throw new IllegalArgumentException();
        }
        return squares[position.getRow()][position.getColumn()].setType(type);
    }

    /**
     * Gets number of rows.
     *
     * @return number of rows.
     */
    public int getNbRow() {
        int row;
        for (row = 0; row < squares.length; row++) {
            //Row index gets incremented, counts number of rows.
        }
        return row;
    }

    /**
     * Gets number of columns.
     *
     * @return number of columns.
     */
    public int getNbColumn() {
        int col = -1;
        for (Square[] square : squares) {
            for (col = 0; col < square.length; col++) {
                //Columni index gets incremented, counts number of columns.
            }
        }
        return col;
    }

}
