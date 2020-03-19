/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.text;

import java.util.Scanner;
import model.Board;
import model.Direction;
import model.Position;
import model.SquareType;

/**
 *
 * @author router
 */
public class View {

    static Scanner keyboard = new Scanner(System.in);

    /**
     * Displays the given board in a new String Array, does not show null.
     *
     * @param board Board given to display
     */
    public static void displayBoard(Board board) {
        String[][] tab = new String[board.getNbRow()][board.getNbColumn()];
        // Populating the new array "tab".
        for (int row = 0; row < tab.length; row++) {
            for (int col = 0; col < tab[row].length; col++) {
                Position position = new Position(row, col);
                if (board.isInside(position) && board.getSquareType(position)
                        == SquareType.GRASS) {
                    tab[row][col] = "GRASS";
                } else if (board.isInside(position)
                        && board.getSquareType(position) == SquareType.STAR) {
                    tab[row][col] = "STAR ";
                } else {
                    tab[row][col] = "     "; // To not show null on board.
                }
            }
        }
        //Displays the new array "tab".
        for (String[] tab1 : tab) {
            for (String tab11 : tab1) {
                System.out.print(tab11 + " ");
            }
            System.out.println();
        }
    }

    /**
     * Displays error message.
     *
     * @param message Message to display.
     */
    public void displayError(String message) {
        System.err.println("Error :" + message);
    }

    /**
     * Asks user for a position
     *
     * @return a new position object.
     */
    public static Position askPosition() {
        int idxRow;
        int idxCol;
        System.out.println("Please enter a row");
        idxRow = intValidation();
        System.out.println("Please enter a column");
        idxCol = intValidation();
        Position position = new Position(idxRow, idxCol);
        return position;
    }
    
    /**
     * This method checks for valid integer.
     * 
     * @return a valid int.
     */
    public static int intValidation (){
        while (!keyboard.hasNextInt()){
            keyboard.next();
            System.out.println("Please enter a valid integer");
        }
        return keyboard.nextInt();
        
    }

    /**
     * Asks user for a direction
     *
     * @return a new direction object.
     */
    public static Direction askDirection() {
        String dir = null;
        do {
            System.out.println("Enter a direction. Valid directions are NORTH, "
                    + "SOUTH, EAST or WEST");
            dir = keyboard.nextLine().toUpperCase();
        } while (!"WEST".equals(dir) && !"NORTH".equals(dir)
                && !"EAST".equals(dir) && !"SOUTH".equals(dir));

        switch (dir) {
            case "NORTH":
                Direction directionN = Direction.NORTH;
                return directionN;
            case "SOUTH":
                Direction directionS = Direction.SOUTH;
                return directionS;
            case "EAST":
                Direction directionE = Direction.EAST;
                return directionE;
            case "WEST":
                Direction directionW = Direction.WEST;
                return directionW;
            default:
                return null; // Will never return
        }
    }

    public static void main(String[] args) {
        displayBoard(Board.getInitialBoard());
        askPosition();
        askDirection();

    }

}
