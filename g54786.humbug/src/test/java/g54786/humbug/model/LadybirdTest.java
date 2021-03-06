package g54786.humbug.model;

import g54786.humbug.model.animal.Animal;
import g54786.humbug.model.animal.Ladybird;
import static g54786.humbug.model.SquareType.GRASS;
import static g54786.humbug.model.SquareType.STAR;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 * Tests for ladybird class.
 *
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public class LadybirdTest {

    private Board board;
    private Animal[] animals;

    @BeforeEach
    public void setUp() {
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
        animals = new Animal[]{
            new Ladybird(new Position(0, 0)) {
            }
        };
    }

    /**
     * Test of move method, of class Ladybird.
     */
    @Test
    public void testMove() {
        System.out.println("move_general");
        Ladybird instance = (Ladybird) animals[0];
        Position expResult = new Position(0, 2); //.next(Direction.EAST);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Ladybird.
     */
    @Test
    public void testMove_not_inside() {
        System.out.println("move not inside");
        Ladybird instance = (Ladybird) animals[0];
        Position expResult = null; //fall;
        Position result = instance.move(board, Direction.WEST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Ladybird.
     */
    @Test
    public void testMove_next_notfree() {
        animals = new Animal[]{
            new Ladybird(new Position(0, 2)) {
            },
            new Ladybird(new Position(0, 0))
        };
        System.out.println("move next case not free");
        Ladybird instance = (Ladybird) animals[1];
        Position expResult = new Position(0, 1); //don't move
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Ladybird.
     */
    @Test
    public void testMove_next_onstar() {
        animals = new Animal[]{
            new Ladybird(new Position(0, 2)) {
            }
        };
        System.out.println("move next on star with win");
        Ladybird instance = (Ladybird) animals[0];
        Position expResult = new Position(2, 2);
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
        assertTrue(instance.isOnStar());
        assertEquals(GRASS, board.getSquareType(result));
    }

    /**
     * Test of move method, of class Ladybird.
     */
    @Test
    public void testMove_passOnStar() {
        System.out.println("move and pass on star without win");
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(STAR), new Square(GRASS), new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS), null},
            {null, null, new Square(STAR), null}
        });

        Ladybird instance = (Ladybird) animals[0];
        Position expResult = new Position(0, 2);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
        assertFalse(animals[0].isOnStar());
        assertFalse(board.getSquareType(new Position(0, 1)) == GRASS);
    }

    @Test
    public void testMove_wallOutside() {
        Square SouthSquare = new Square(GRASS);
        SouthSquare.setSouthWall(true);
        board = new Board(new Square[][]{
            {SouthSquare, new Square(GRASS), null},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
        System.out.println("Try to move into a wall");
        Ladybird instance = (Ladybird) animals[0];
        Position expResult = new Position(0, 0);
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertTrue(SouthSquare.hasWall(Direction.SOUTH));
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Ladybird.
     */

    @Test
    public void testMove_wallInside() {
        Square SouthSquare = new Square(GRASS);
        SouthSquare.setSouthWall(true);
        board = new Board(new Square[][]{
            {new Square(GRASS), SouthSquare, null},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
        animals = new Animal[]{
            new Ladybird(new Position(0, 1)) {
            }};
        System.out.println("Try to move into a wall inside the board");
        Ladybird instance = (Ladybird) animals[0];
        Position expResult = new Position(0, 1);
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertTrue(SouthSquare.hasWall(Direction.SOUTH));
        assertEquals(expResult, result);
    }

}
