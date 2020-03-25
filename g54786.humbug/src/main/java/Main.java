/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controller.Controller;
import model.Game;
import view.text.View;

/**
 * Main class for Humbug game.
 * 
 * @author Gregoy van der Pluijm <54786@etu.he2b.be>
 */
public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(new Game() {}, new View() {});
        controller.startGame();
    }
    
}
