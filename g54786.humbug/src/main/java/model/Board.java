/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Board initialization.
 *
 * @author router
 */
public class Board {

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
     * Initializes level 1 board.
     *
     * @return level 1 board.
     */
    public static Board getInitialBoard() {
        Square grass = new Square(SquareType.GRASS);//Creates GRASS type Square
        Square[][] lvl1 = {{grass, grass, null}, {null, grass, grass},
        {null, null, grass}};
        Board board = new Board(lvl1);
        return board;
    }

    /**
     * Checks if given position is on the board game or not.
     *
     * @param p Position to check.
     * @return True if exists, false if not.
     */
    public boolean isInside(Position p) {
        boolean isInside = true;
        if (p == null) {
            throw new IllegalArgumentException();
        }
        if (p.getRow() >= this.getNbRow() // checks if row is bigger than size 
                || p.getColumn() >= this.getNbColumn() // check if column is bigger than size
                || p.getRow() < 0 || p.getColumn() < 0) {
            isInside = false;
        } else if (squares[p.getRow()][p.getColumn()] == null) {
            isInside = false;
        }
        return isInside;
    }

    /**
     * Gets square type of given position.
     *
     * @param p Position to check.
     * @return Square type of given position
     */
    public SquareType getSquareType(Position p) {
        if (squares[p.getRow()][p.getColumn()] == null) {
            throw new IllegalArgumentException();
        }
        return squares[p.getRow()][p.getColumn()].getType();
    }
    public SquareType setSquareType (Position p, SquareType type) {
        return squares[p.getRow()][p.getColumn()].setType(type);
    }

    /**
     * Checks number of rows in board.
     *
     * @return number of rows.
     */
    public int getNbRow() {
        int row;
        for (row = 0; row < squares.length; row++) {
        }
        return row;
    }

    /**
     * Checks number of columns.
     *
     * @return number of columns.
     */
    public int getNbColumn() {
        int col = -1;
        for (int row = 0; row < squares.length; row++) {
            for (col = 0; col < squares[row].length; col++) {
            }
        }
        return col;
    }

}
