/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54786.humbug.model;

import g54786.humbug.model.Animal.Animal;
import g54786.humbug.model.Animal.Snail;
import g54786.humbug.model.Animal.Spider;

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
     * Getter for level.
     *
     * @param n Level
     * @return
     */
    public Level getLevel(int n) {
        int nMoves;
        Square grass = new Square(SquareType.GRASS);
        Square star = new Square(SquareType.STAR);
        switch (n) {
            case 1:
                board = new Board(new Square[][]{
                    {grass, grass, null},
                    {null, grass, grass},
                    {null, null, star}});
                nMoves = 4;
                animals = new Animal[]{
                    new Snail(new Position(0, 0)) {
                    }};
                return new Level(board, animals, nMoves);
            case 2:
                board = new Board(new Square[][]{
                    {grass, grass, null},
                    {null, star, null},
                    {star, grass, star},
                    {null, grass, null}});
                nMoves = 5;
                animals = new Animal[]{
                    new Snail(new Position(0, 0)) {
                    },
                    new Snail(new Position(2, 1)) {
                    },
                    new Snail(new Position(3, 1)) {
                    }};
                return new Level(board, animals, nMoves);
            case 3:
                board = new Board(new Square[][]{
                    {grass, grass, grass},
                    {grass, null, grass},
                    {star, grass, grass}});
                nMoves = 4;
                animals = new Animal[]{
                    new Spider(new Position(2, 0)) {
                    }};
                return new Level(board, animals, nMoves);
            default:
                break;
        }
        return null;
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
