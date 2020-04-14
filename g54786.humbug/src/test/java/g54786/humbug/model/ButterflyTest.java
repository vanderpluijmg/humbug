/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54786.humbug.model;

import g54786.humbug.model.Animal.Animal;
import g54786.humbug.model.Animal.Butterfly;
import static g54786.humbug.model.SquareType.GRASS;
import static g54786.humbug.model.SquareType.STAR;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public class ButterflyTest {
    
    private Board board;
    private Animal[] animals;

    @BeforeEach
    public void setUp() {
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS),
                new Square(GRASS), new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
        animals = new Animal[]{
          new Butterfly(new Position(0, 0)) {
            }
        };
    }

    /**
     * Test of move method, of class Bumblebee.
     */
    @Test
    public void testMove() {
        System.out.println("move general");
        Butterfly instance = (Butterfly) animals[0];
        Position expResult = new Position(0, 3); //
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Bumblebee.
     */
    @Test
    public void testMove_animalAt_destination() {
        animals = new Animal[]{
            new Butterfly(new Position(0, 0)) {
            },
            new Butterfly(new Position(0, 3)) {
            }
        };
        System.out.println("animal on arrival go to next square");
        Butterfly instance = (Butterfly) animals[0];
        Position expResult = new Position(0, 4); // Jump over.
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Bumblebee.
     */
    @Test
    public void testMove_animalAt_destination_nextNull() {
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS),
                new Square(GRASS), null},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
        animals = new Animal[]{
            new Butterfly(new Position(0, 0)) {
            },
            new Butterfly(new Position(0, 3)) {
            }
        };
        System.out.println("animal on arrival, next square fall ");
        Butterfly instance = (Butterfly) animals[0];
        Position expResult = null; //fall
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Bumblebee.
     */
    @Test
    public void testMove_animalAt_destination_nextOnStar() {
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS),
                new Square(GRASS), new Square(STAR)},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
        animals = new Animal[]{
            new Butterfly(new Position(0, 0)) {
            },
            new Butterfly(new Position(0, 3)) {
            }
        };
        System.out.println("animal on arrival, next square star ");
        Butterfly instance = (Butterfly) animals[0];
        Position expResult = new Position(0, 4); //fall
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
        assertTrue(instance.isOnStar());
        assertEquals(GRASS, board.getSquareType(result));
    }

    /**
     * Test of move method, of class Bumblebee.
     */
    @Test
    public void testMove_next_onStar() {
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS),
                new Square(STAR)},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
        Butterfly instance = (Butterfly) animals[0];
        Position expResult = new Position(0, 3); //fall
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
        assertTrue(instance.isOnStar());
        assertEquals(GRASS, board.getSquareType(result));
    }

    /**
     * Test of move method, of class Bumblebee.
     */
    @Test
    public void testMove_nextNull() {
        System.out.println("arrival null");
        Butterfly instance = (Butterfly) animals[0];
        Position expResult = null; //fall
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Bumblebee.
     */
    @Test
    public void testMove_flyOverNull() {
        board = new Board(new Square[][]{
            {new Square(GRASS), null, null, new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
        System.out.println("fly over null");
        Butterfly instance = (Butterfly) animals[0];
        Position expResult = new Position(0, 3);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Bumblebee.
     */
    @Test
    public void testMove_flyOverAnimal() {
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS),
                new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
        animals = new Animal[]{
            new Butterfly(new Position(0, 0)) {
            },
            new Butterfly(new Position(0, 1)) {
            },
            new Butterfly(new Position(0, 2)) {
            }
        };

        System.out.println("fly over animal");
        Butterfly instance = (Butterfly) animals[0];
        Position expResult = new Position(0, 3);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }
    /**
     * Test of move method, of class Bumblebee.
     */
    @Test
    public void testMove_bouceOver_twoAnimals() {
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS),
                new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
        animals = new Animal[]{
            new Butterfly(new Position(0, 0)) {
            },
            new Butterfly(new Position(0, 3)) {
            },
            new Butterfly(new Position(0, 4)) {
            }
        };

        System.out.println("fly over animal");
        Butterfly instance = (Butterfly) animals[0];
        Position expResult = new Position(0, 5);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }
    

    
}
