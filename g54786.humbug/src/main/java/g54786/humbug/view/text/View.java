package g54786.humbug.view.text;

import java.util.Scanner;
import g54786.humbug.model.Animal.Animal;
import g54786.humbug.model.Board;
import g54786.humbug.model.Direction;
import g54786.humbug.model.Position;
import g54786.humbug.model.SquareType;
import g54786.humbug.model.Animal.Snail;
import g54786.humbug.model.Animal.Spider;

/**
 * Defines how the game is seen by the user.
 *
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public abstract class View implements InterfaceView {

    static Scanner keyboard = new Scanner(System.in);

    /**
     * Displays the given board in a new String Array, does not show null.
     *
     * @param board Board given to display.
     * @param animals All animals on board.
     */
    @Override
    public void displayBoard(Board board, Animal... animals) {
        String[][] tab = new String[board.getNbRow()][board.getNbColumn()];
        //Populating the new array "tab" by defining every square case.
        for (int row = 0; row < tab.length; row++) {
            for (int col = 0; col < tab[row].length; col++) {
                Position position = new Position(row, col);
                if (board.isInside(position) && board.getSquareType(position)
                        .equals(SquareType.GRASS)) {
                    tab[row][col] = TerminalColor.BG_GREEN + "     ";
                } else if (board.isInside(position)
                        && board.getSquareType(position)
                                .equals(SquareType.STAR)) {
                    tab[row][col] = TerminalColor.BG_RED + "  *  ";
                } else {
                    tab[row][col] = TerminalColor.BG_BLUE + "     "; //To not show null on board.
                }
                for (Animal animal : animals) {
                    if (animal.getPositionOnBoard().equals(position)) {
                        if (animal instanceof Snail) {
                            tab[row][col] = TerminalColor.BG_GREEN + "  SN ";
                        } else if (animal instanceof Spider) {
                            tab[row][col] = TerminalColor.BG_GREEN + "  SP ";
                        }
                    }
                }
            }
        }

        displayArray(tab);
    }
    /**
     * Displays an array.
     * 
     * @param tab Array to display
     */
    private void displayArray(String[][] tab) {
        System.out.println("  0  " + "  1  " + "  2  ");
        for (String[] rows : tab) {
            for (String cols : rows) {
                System.out.print(TerminalColor.BLACK_UNDERLINE + cols);
            }
            System.out.println();
        }
    }

    /**
     * Displays error message.
     *
     * @param message Message to display.
     */
    @Override
    public void displayError(String message) {
        System.err.println(message);
    }

    /**
     * Asks user for a position.
     *
     * @return The position given by row and column coordinates.
     */
    @Override
    public Position askPosition() {
        int idxRow;
        int idxCol;
        System.out.println("Please enter the animals row you wish to select");
        idxRow = intValidation();
        System.out.println("Please enter the animals column you wish to select");
        idxCol = intValidation();
        Position wantedPosition = new Position(idxRow, idxCol);
        return wantedPosition;
    }

    /**
     * This method checks for valid integer.
     *
     * @return A integer.
     */
    private static int intValidation() {
        while (!keyboard.hasNextInt()) {
            keyboard.next();
            System.out.println("Please enter a valid integer");
        }
        return keyboard.nextInt();

    }

    /**
     * Asks user for a direction.
     *
     * @return The direction given by the user.
     */
    @Override
    public Direction askDirection() {
        String dir;
        do {
            System.out.println("Enter a direction. Valid directions are NORTH, "
                    + "SOUTH, EAST or WEST");
            dir = keyboard.next().toUpperCase();
        } while (!"WEST".equals(dir) && !"NORTH".equals(dir)
                && !"EAST".equals(dir) && !"SOUTH".equals(dir));

        switch (dir) {
            case "WEST":
                Direction directionW = Direction.WEST;
                return directionW;
            case "NORTH":
                Direction directionN = Direction.NORTH;
                return directionN;
            case "EAST":
                Direction directionE = Direction.EAST;
                return directionE;
            default:
                Direction directionS = Direction.SOUTH;
                return directionS;    
        }
    }
    
}
