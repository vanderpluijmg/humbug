package g54786.humbug.model;

import g54786.humbug.model.animal.Animal;
import g54786.humbug.model.animal.Snail;
import static g54786.humbug.model.SquareType.GRASS;
import static g54786.humbug.model.SquareType.STAR;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Pierre Bettens (pbt) <pbettens@he2b.be>
 */
public class SnailTest {

    private Board board;
    private Animal[] animals;

    @BeforeEach
    public void setUp() {
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), null},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
        animals = new Animal[]{
            new Snail(new Position(0, 0)),
            new Snail(new Position(1, 2))
        };
    }

    /**
     * Test of move method, of class Snail.
     */
    @Test
    public void testMove() {
        System.out.println("move_general");
        Snail instance = (Snail) animals[0];
        Position expResult = new Position(0, 1); //.next(Direction.EAST);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Snail.
     */
    @Test
    public void testMove_next_notfree() {
        System.out.println("move next case not free");
        Snail instance = (Snail) animals[0];
        animals[1].setPositionOnBoard(new Position(0, 1));
        Position expResult = new Position(0, 0); //don't move
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Snail.
     */
    @Test
    public void testMove_next_onstar() {
        System.out.println("move next on star");
        Snail instance = (Snail) animals[1];
        Position expResult = new Position(2, 2);
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
        assertTrue(instance.isOnStar());
        assertEquals(GRASS, board.getSquareType(result));
    }

    /**
     * Test of move method, of class Snail.
     */
    @Test
    public void testMove_next_notinside_() {
        System.out.println("move next case null");
        Snail instance = (Snail) animals[0];
        Position expResult = null; // move and fall
        Position result = instance.move(board, Direction.WEST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Spider.
     */
    @Test
    public void testMove_wall() {
        Square SouthSquare = new Square(GRASS);
        SouthSquare.setSouthWall(true);
        board = new Board(new Square[][]{
            {SouthSquare, new Square(GRASS), null},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
        System.out.println("Try to move into a wall");
        Snail instance = (Snail) animals[0];
        Position expResult = new Position(0, 0);
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertTrue(SouthSquare.hasWall(Direction.SOUTH));
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Spider.
     */
    @Test
    public void testMove_wallInside() {
        Square eastWall = new Square(GRASS);
        eastWall.setEastWall(true);
        board = new Board(new Square[][]{
            {eastWall, new Square(GRASS), new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
        animals = new Animal[]{
            new Snail(new Position(0, 0)) {
            }};
        System.out.println("Try to move into a wall inside the board");
        Snail instance = (Snail) animals[0];
        Position expResult = new Position(0, 0);
        Position result = instance.move(board, Direction.EAST, animals);
        assertTrue(eastWall.hasWall(Direction.EAST));
        assertEquals(expResult, result);
    }

}
