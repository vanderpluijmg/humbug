/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * This is an interface for Game class.
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public interface Model {
    Board getBoard();
    Animal[] getAnimals();
    void startLevel(int level);
    boolean levelIsOver();
    void move(Position position, Direction direction);
    
}
