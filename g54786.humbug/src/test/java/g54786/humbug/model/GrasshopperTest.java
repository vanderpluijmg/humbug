/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54786.humbug.model;

import g54786.humbug.model.animal.Animal;
import g54786.humbug.model.animal.Grasshopper;
import static g54786.humbug.model.SquareType.GRASS;
import static g54786.humbug.model.SquareType.STAR;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public class GrasshopperTest {
    
    private Board board;
    private Animal[] animals;

    @BeforeEach
    public void setUp() {
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
        animals = new Animal[] {
            new Grasshopper(new Position(0, 0)) {},
            new Grasshopper(new Position(1, 2)) {}
        };
    }

    /**
     * Test of move method, of class Grasshopper.
     */
    @Test
    public void testMove() {
        System.out.println("move_general");
        Grasshopper instance = (Grasshopper) animals[0];
        Position expResult = new Position(0, 1); //.next(Direction.EAST);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Grasshopper.
     */
    @Test
    public void testMove_next_notfree() {
        System.out.println("move next case not free");
        Grasshopper instance = (Grasshopper) animals[0];
        animals[1].setPositionOnBoard(new Position(0, 1));
        Position expResult = new Position(0, 2); //jump over
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

  
    
    /**
     * Test of move method, of class Grasshopper.
     */
    @Test
    public void testMove_next_onstar() {
        System.out.println("move next on star");
        Grasshopper instance = (Grasshopper) animals[1];
        Position expResult = new Position(2, 2);
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
        assertTrue(instance.isOnStar());
        assertEquals(GRASS, board.getSquareType(result));
    }

    /**
     * Test of move method, of class Grasshopper.
     */
    @Test
    public void testMove_next_notinside() {
        System.out.println("move next case null");
        Grasshopper instance = (Grasshopper) animals[0];
        Position expResult = null; // move and fall
        Position result = instance.move(board, Direction.WEST, animals);
        assertEquals(expResult, result);
    }
    /**
     * Test of move method, of class Grasshopper.
     */
    @Test
    public void testMove_bounceOver_twoAnimals() {
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
        animals = new Animal[] {
            new Grasshopper(new Position(0, 0)) {},
            new Grasshopper(new Position(0, 1)) {},
            new Grasshopper(new Position(0, 2)) {}
        };
        System.out.println("move next, bounce over 2 animals");
        Grasshopper instance = (Grasshopper) animals[0];
        Position expResult = new Position(0, 3); 
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }    
}
    