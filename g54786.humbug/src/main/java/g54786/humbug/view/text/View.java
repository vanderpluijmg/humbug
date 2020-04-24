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
     * Displays the given board in a new String Array, does not show null.
     *
     * @param board Board given to display.
     * @param animals All animals on board.
     */
    @Override
    public void displayBoard(Board board, Animal... animals) {
        String [][] tab = new String [board.getNbRow()*5][board.getNbColumn()];
        for (int i = 0, row = 0; i < tab.length; i = i+5, row++) {
            for (int col = 0; col < tab [row].length; col++) {
                Position position = new Position(row,col);
                if (board.isInside(position)) {
                    tab[i][col] = tab [i+4][col] = "-----";
                    switch (board.getSquareType(position)){           
                        case GRASS :
                            displayWalls(tab, col, i, board, position);
                            displayAnimals(tab, col, i, animals);
                            break;
                        case STAR:
                                displayWalls(tab, col, i, board, position);
                                tab [i+2][col] = "| * |";
                            break;
                    }
                } else { tab[i][col] =tab[i+1][col]=tab[i+2][col] =tab[i+3][col]
                        = tab [i+4][col] = TerminalColor.BG_BLUE + "     ";
                    }
            }
        }
        displayArray(tab);
    }
    /**
     * Displays the different walls on the game.
     * @param tab Array in which to display the walls.
     * @param col Which column to display it in.
     * @param i Sets the correct gap in the array.
     * @param board Board in which to check for walls.
     * @param position Position to check for walls.
     */
    private void displayWalls (String [][] tab, int col, int i, Board board, Position position){
        if (board.getSquare(position).hasWall(Direction.NORTH)){
            tab[i+1][col] = "| ° |";
            tab [i+3][col] = "|   |";            
        } else if (board.getSquare(position).hasWall(Direction.SOUTH)){
            tab[i+1][col] = "|   |";
            tab [i+3][col] = "|   |";
        } else if (board.getSquare(position).hasWall(Direction.EAST)){
            tab[i+1][col] = "|    " + TerminalColor.BLACK_BOLD +"|";
            tab [i+3][col] = "|    " + TerminalColor.BLACK_BOLD +"|";
        } else if (board.getSquare(position).hasWall(Direction.WEST)){
            tab[i+1][col] =  TerminalColor.BLACK_BOLD + "|" +"    |";
            tab [i+3][col] = TerminalColor.BLACK_BOLD + "|" +"    |";
        }
    }
    /**
     * Displays the correct animal.
     * @param tab Array in which to display the animals.
     * @param col Which column to display it in.
     * @param i Sets the correct gap in the array.
     * @param animals Animals it must display. 
     */
    private void displayAnimals (String [][] tab, int col, int i, Animal ... animals){
        for (Animal animal : animals){
            if (animal instanceof Snail){
                tab [i+2][col] = "|sn |";
            }else if (animal instanceof Spider){
                tab [i+2][col] = "|sp |";
            }else if (animal instanceof Bumblebee){
                tab [i+2][col] = "|bb |";
            }else if (animal instanceof Butterfly){
                tab [i+2][col] = "|bt |";
            }else if (animal instanceof Grasshopper){
                tab [i+2][col] = "|gh  |";
            }else {
                tab [i+2][col] = "|lb  |";
            }
        }
    }
    /**
     * Displays the array
     * @param tab Array to display
     */
    private static void displayArray (String[][] tab){
        for (String[] strings : tab) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println("");
            
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
     * Displays remaining moves.
     * @param remainingMoves Number of move remaining for the user.
     */
    @Override
    public void displayRemaningMoves (int remainingMoves){
        System.out.println(remainingMoves);
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
