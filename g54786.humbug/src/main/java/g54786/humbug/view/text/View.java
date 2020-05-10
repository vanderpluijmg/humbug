package g54786.humbug.view.text;

import java.util.Scanner;
import g54786.humbug.model.animal.Animal;
import g54786.humbug.model.animal.Bumblebee;
import g54786.humbug.model.animal.Butterfly;
import g54786.humbug.model.animal.Grasshopper;
import g54786.humbug.model.animal.Ladybird;
import g54786.humbug.model.animal.Snail;
import g54786.humbug.model.animal.Spider;
import g54786.humbug.model.Board;
import g54786.humbug.model.Direction;
import g54786.humbug.model.Position;
import g54786.humbug.model.SquareType;

/**
 * Defines how the game is seen by the user.
 *
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public abstract class View implements InterfaceView {

    static Scanner keyboard = new Scanner(System.in);

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
     * Displays an array.
     *
     * @param tab Array to display.
     * @param board Board to get dimensions from.
     */
    private static void displayArray(String[][] tab, Board board) {
        int index = 0;
        int nbCol = board.getNbColumn();
        int nbRow = board.getNbRow() * 5;
        for (int i = 0; i < nbCol; i++) {
            System.out.print("    " + i); //Displays column indicators
        }
        System.out.println("");
        for (String[] strings : tab) {
            index++;
            if ((index - 3) % 5 == 0) {
                System.out.print((index - 3) / 5 + " "); //Displays row indicator.
            } else {
                System.out.print("  "); //To not have unwanted gaps in view.
            }
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println("");
        }
    }

    /**
     * Displays all the walls on the board.
     *
     * @param star True if square is of square type star.
     * @param board Board game.
     * @param position Position of square.
     * @param i Applies correct gap.
     * @param col Column of position.
     * @param tab Array in which to display walls.
     */
    private void displayWalls(boolean star, Board board, Position position,
            int i, int col, String[][] tab) {
        if (star) {
            if (board.getSquare(position).hasWall(Direction.NORTH)) {
                tab[i][col] = TerminalColor.RED + "-----";
            } else if (board.getSquare(position).hasWall(Direction.SOUTH)) {
                tab[i + 4][col] = TerminalColor.RED + "-----";
            } else if (board.getSquare(position).hasWall(Direction.EAST)) {
                tab[i + 1][col] = tab[i + 2][col] = tab[i + 3][col]
                        = "|" + TerminalColor.RED + "   |";
            } else if (board.getSquare(position).hasWall(Direction.WEST)) {
                tab[i + 1][col] = tab[i + 3][col]
                        = "\033[31m|" + TerminalColor.YELLOW + "   |";
                tab[i + 2][col] = "\033[31m|" + TerminalColor.YELLOW + " * |";
            }
        } else if (board.getSquare(position).hasWall(Direction.NORTH)) {
            tab[i][col] = TerminalColor.RED + "-----";
        } else if (board.getSquare(position).hasWall(Direction.SOUTH)) {
            tab[i + 4][col] = TerminalColor.RED + "-----";
        } else if (board.getSquare(position).hasWall(Direction.EAST)) {
            tab[i + 1][col] = tab[i + 2][col] = tab[i + 3][col]
                    = "|" + TerminalColor.RED + "   |";
        } else if (board.getSquare(position).hasWall(Direction.WEST)) {
            tab[i + 1][col] = tab[i + 2][col] = tab[i + 3][col]
                    = TerminalColor.RED + "|   " + "|";
        }
    }

    /**
     * Displays the given board in a new String Array, null is blank.
     *
     * @param board Board given to display.
     * @param animals All animals on board.
     */
    @Override
    public void displayBoard(Board board, Animal... animals) {
        String[][] tab = new String[board.getNbRow() * 5][board.getNbColumn()];
        for (int i = 0, row = 0; i < tab.length; i = i + 5, row++) {
            for (int col = 0; col < tab[row].length; col++) {
                Position position = new Position(row, col);
                if (board.isInside(position) && board.getSquareType(position)
                        .equals(SquareType.GRASS)) {
                    tab[i][col] = tab[i + 4][col] = TerminalColor.GREEN
                            + "-----";
                    tab[i + 1][col] = tab[i + 3][col] = TerminalColor.GREEN
                            + "|   |";
                    tab[i + 2][col] = TerminalColor.GREEN + "|   |";
                    displayWalls(false, board, position, i, col, tab);
                } else if (board.isInside(position)
                        && board.getSquareType(position)
                                .equals(SquareType.STAR)) {
                    tab[i][col] = tab[i + 4][col] = TerminalColor.YELLOW
                            + "-----";
                    tab[i + 1][col] = tab[i + 3][col] = TerminalColor.YELLOW
                            + "|   |";
                    tab[i + 2][col] = TerminalColor.YELLOW + "| * |";
                    displayWalls(true, board, position, i, col, tab);
                //Shows blank if position is null.
                } else {
                    tab[i][col] = tab[i + 1][col] = tab[i + 2][col]
                            = tab[i + 3][col] = tab[i + 4][col] = "     ";
                }
                for (Animal animal : animals) {
                    if (animal.getPositionOnBoard().equals(position)
                            && !animal.isOnStar()) {
                        if (animal instanceof Snail) {
                            tab[i + 2][col] = TerminalColor.BLUE + "|SNA|";
                        } else if (animal instanceof Spider) {
                            tab[i + 2][col] = TerminalColor.BLUE + "|SPI|";
                        } else if (animal instanceof Bumblebee) {
                            tab[i + 2][col] = TerminalColor.BLUE + "|BUM|";
                        } else if (animal instanceof Ladybird) {
                            tab[i + 2][col] = TerminalColor.BLUE + "|LAD|";
                        } else if (animal instanceof Butterfly) {
                            tab[i + 2][col] = TerminalColor.BLUE + "|BUT|";
                        } else if (animal instanceof Grasshopper) {
                            tab[i + 2][col] = TerminalColor.BLUE + "|GRA|";
                        }
                    }
                }
            }
        }
        displayArray(tab, board);
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
     * Displays remaining moves.
     *
     * @param remainingMoves Number of moves remaining for the user.
     */
    @Override
    public void displayRemaningMoves(int remainingMoves) {
        System.out.println("Remaining number of moves: " + remainingMoves);
    }

    /**
     * Displays caption to know which animal is what.
     */
    @Override
    public void displayCaption() {
        System.out.println("SNA = Snail");
        System.out.println("SPI = SPider");
        System.out.println("BUT = Butterfly");
        System.out.println("BUM = Bumblebee");
        System.out.println("GRA = Grasshopper");
        System.out.println("LAD = Ladybird");
    }

    /**
     * Displays given level.
     *
     * @param n Level to display.
     */
    @Override
    public void displayLevel(int n) {
        System.out.println("You are at level: " + n);
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
     * Asks user for a direction.
     *
     * @return The direction given by the user.
     */
    @Override
    public Direction askDirection() {
        String dir;
        do {
            System.out.println("Would you like to go UP, DOWN, LEFT or RIGHT?");
            dir = keyboard.next().toUpperCase();
        } while (!"UP".equals(dir) && !"DOWN".equals(dir)
                && !"RIGHT".equals(dir) && !"LEFT".equals(dir));
        switch (dir) {
            case "LEFT":
                Direction directionW = Direction.WEST;
                return directionW;
            case "UP":
                Direction directionN = Direction.NORTH;
                return directionN;
            case "RIGHT":
                Direction directionE = Direction.EAST;
                return directionE;
            default:
                Direction directionS = Direction.SOUTH;
                return directionS;
        }
    }
}
