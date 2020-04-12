/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54786.humbug.model.Animal;

import g54786.humbug.model.Board;
import g54786.humbug.model.Direction;
import g54786.humbug.model.Position;
import g54786.humbug.model.SquareType;

/**
 *
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public abstract class Bumblebee extends Animal {

    public Bumblebee(Position positiononBoard) {
        super(positiononBoard);
    }

    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
    
        Position nextPosition = getPositionOnBoard().next(direction);
        
        return nextPosition;
        
    }   
}
