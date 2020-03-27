/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static model.SquareType.GRASS;
import static model.SquareType.STAR;
import org.junit.jupiter.api.Test;
import model.Game;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public class GameTest {
    private Board board;
    private Animal[] animals;
    
    public GameTest() {
    }

    /**
     * Test of getBoard method, of class Game.
     */
    @Test
    public void testGetBoard() {
    }

    /**
     * Test of getAnimals method, of class Game.
     */
    @Test
    public void testGetAnimals() {
    }

    /**
     * Test of startLevel method, of class Game.
     */
    @Test
    public void testStartLevel() {
    }

    /**
     * Test of levelIsOver method, of class Game.
     */
    @Test
    public void testLevelIsOver() {
    }

    /**
     * Test of move method, of class Game.
     */
    @Test
    public void testMove() {
        System.out.println("Move test");
                board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
                animals = new Animal[] {
            new Snail(new Position(0, 0)) {},
        };
        Position expResult = new Position (0,1);
        Snail instance = (Snail) animals[0];
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    public class GameImpl extends Game {
    }
    
}
