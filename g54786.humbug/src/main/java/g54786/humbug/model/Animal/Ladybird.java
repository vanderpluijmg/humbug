/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g54786.humbug.model.Animal;

import g54786.humbug.model.Board;
import g54786.humbug.model.Direction;
import g54786.humbug.model.Position;

/**
 *
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public class Ladybird extends Animal {

    public Ladybird(Position positiononBoard) {
        super(positiononBoard);
    }

    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 

    }
