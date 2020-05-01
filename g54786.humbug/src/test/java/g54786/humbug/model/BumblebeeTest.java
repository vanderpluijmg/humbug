package g54786.humbug.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import g54786.humbug.model.animal.Animal;
import g54786.humbug.model.animal.Bumblebee;
import static g54786.humbug.model.SquareType.GRASS;
import static g54786.humbug.model.SquareType.STAR;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public class BumblebeeTest {

    private Board board;
    private Animal[] animals;

    @BeforeEach
    public void setUp() {
        board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), new Square(GRASS),
                new Square(GRASS)},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
        animals = new Animal[]{
            new Bumblebee(new Position(0, 0)) {
            }
        };
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
            new Bumblebee(new Position(0, 0)) {
            },
            new Bumblebee(new Position(0, 2)) {
            },
            new Bumblebee(new Position(0, 3)) {
            }
        };

        System.out.println("bounce over multiple animals");
        Bumblebee instance = (Bumblebee) animals[0];
        Position expResult = new Position (0, 4); //Falls after bouncing over 2 animals 
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

}
