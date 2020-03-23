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
 * These at the minimum requirements for a display method.
 * @author router
 */
public interface InterfaceView {
    
    void diplayBoard (Board board, Animal... animals);
    Position askPosition();
    Direction askDirection();
    void displayError(String message);
            
   
    
    
}
