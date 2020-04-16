/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public class NewClass {
    public static String [][] populateBoard (Board board, Animal... animals){
        String [][] tab = new String [board.getNbRow()*5][board.getNbColumn()];
        for (int i = 0, row = 0; i < tab.length; i = i+5, row++) {
            for (int col = 0; col < tab [row].length; col++) {
                Position position = new Position(row,col);
                if (board.isInside(position)) {
                    tab[i][col] = tab [i+4][col] = "-----";
                    tab[i+1][col] = tab [i+3][col] = "|   |";
                    switch (board.getSquareType(position)){
                        case GRASS :
                            tab [i+2][col] = "|   |";
                            break;
                        case STAR: 
                            tab [i+2][col] = "| * |";
                            break;
                        
                    }
                } else { tab[i][col] =tab[i+1][col]=tab[i+2][col] =tab[i+3][col]
                        = tab [i+4][col] = "     ";
                }
            }
        }
        return tab;
    }
    private void displayBoard (String[][] tab){
        for (String[] strings : tab) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println("");
            
        }
    }
    public static void main(String[] args) {
        Board board = Board.getInitialBoard();
        Animal[] animals = new Animal[]{
                    new Snail(new Position(0, 0)) {
                    }};
        String 
    }
    
                    
                    
                    
                    
                    
                    
                    
//                }
//                    tab[row][col] = 1;
//                } else if (board.isInside(position)
//                        && board.getSquareType(position)
//                                .equals(SquareType.STAR)) {
//                    tab[row][col] = 2;
//                } else {
//                    tab[row][col] = 3; //To not show null on board.
//                }
//                for (Animal animal : animals) {
//                    if (animal.getPositionOnBoard().equals(position)) {
//                        if (animal instanceof Snail) {
//                            tab[row][col] = 4;
//                        } else if (animal instanceof Spider) {
//                            tab[row][col] = 5;
//                        }
//                    }
//                }
//            }
//            
//        }
//        return tab;
//    }
//    private String [][] displayBoard (int[][] tab){
//        String [][] tab = new String [tab.length*5][tab[0].length];
//        for (int i = 0, row = 0; i < board.length; i = i+5, row++) {
//            for (int j = 0; j < board[0].length; j++) {
//                Position position = new Position(row, j);
//                 if (board.isInside(position) && board.getSquareType(position)
//                        .equals(SquareType.GRASS)) {
//                
//            }
//        }
//            
//        }
        
}
