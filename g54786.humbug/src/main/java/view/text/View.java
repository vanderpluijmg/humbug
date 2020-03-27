/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.text;

import java.util.Arrays;
import java.util.Scanner;
import model.Animal;
import model.Board;
import model.Direction;
import model.Position;
import model.SquareType;
import model.Snail;
import model.Spider;

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
        //Populating the new array "tab".
        for (int row = 0; row < tab.length; row++) {
            for (int col = 0; col < tab[row].length; col++) {
                Position position = new Position(row, col);
                if (board.isInside(position) && board.getSquareType(position)
                        == SquareType.GRASS) {
                    tab[row][col] = TerminalColor.BG_GREEN +"    ";
                            ;
                } else if (board.isInside(position)
                        && board.getSquareType(position) == SquareType.STAR) {
                    tab[row][col] = TerminalColor.BG_LIGHT_YELLOW + "    ";
                } else {
                    tab[row][col] = TerminalColor.BG_BLUE +"    "
                          ; //To not show null on board.
                }
                for (Animal animal : animals){
                    if (animal.getPositionOnBoard().equals(position)){
                        if (animal instanceof Snail){
                            tab [row][col] = TerminalColor.BG_GREEN +" SN ";
                        }else if (animal instanceof Spider){
                            tab [row][col] = TerminalColor.BG_GREEN +" SP ";
                        }
                    }
                }
            }
        }
        
        //Displays the new array "tab".
        System.out.println("");
        for (String[] tab1 : tab) {
            for (String tab11 : tab1) {
                System.out.print(tab11);
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
        System.err.println("Error :" + message);
    }

    /**
     * Asks user for a position
     *
     * @return The position given by row and column coordinates.
     */
    @Override
    public Position askPosition() {
        int idxRow;
        int idxCol;
        System.out.println("Please enter the animals row");
        idxRow = intValidation();
        System.out.println("Please enter the animals column");
        idxCol = intValidation();
        Position position = new Position(idxRow, idxCol);
        return position;
    }

    /**
     * This method checks for valid integer.
     *
     * @return A integer.
     */
    public static int intValidation() {
        while (!keyboard.hasNextInt()) {
            keyboard.next();
            System.out.println("Please enter a valid integer");
        }
        return keyboard.nextInt();

    }

    /**
     * Asks user for a direction
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
