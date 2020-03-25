/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.text;

import model.Animal;
import model.Board;
import model.Direction;
import model.Position;

/**
 * This is an interface for view class.
 * 
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public interface InterfaceView {

    void displayBoard(Board board, Animal... animal);
    Position askPosition();
    Direction askDirection();
    void displayError(String message);
            
   
    
    
}
