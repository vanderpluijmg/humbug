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
public class Ladybird extends Animal {

    public Ladybird(Position positiononBoard) {
        super(positiononBoard);
    }

    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        
        Position initPosition = getPositionOnBoard();
        Position nextPosition = initPosition.next(direction);
        int numberOfMoves = 0;
        while (board.isInside(nextPosition)) {
            numberOfMoves++;
            initPosition = getPositionOnBoard();
            nextPosition = initPosition.next(direction);
            for (Animal animal : animals) {
                if (animal.getPositionOnBoard().equals(nextPosition)) {
                    setPositionOnBoard(initPosition);
                    return initPosition;
                }
            }
            if (board.getSquareType(nextPosition) == SquareType.STAR) {
                setOnStar(true);
                board.setSquareType(nextPosition, SquareType.GRASS);
                setPositionOnBoard(nextPosition);
                return nextPosition;
            } else if (numberOfMoves == 2){
                return nextPosition;
            }else  {
                setPositionOnBoard(nextPosition);
            } 
        }
        setPositionOnBoard(null);
        return null;
    }

}
    

 

    