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

        Position initPosition = getPositionOnBoard();
        Position nextPosition = initPosition.next(direction);

        while (board.isInside(nextPosition)) {
            for (Animal animal : animals) {
                if (animal.getPositionOnBoard().equals(nextPosition)) {
                    if (board.getSquareType(getPositionOnBoard()) == SquareType.STAR){
                        setOnStar(true);
                        board.setSquareType(getPositionOnBoard(), SquareType.GRASS);
                        setPositionOnBoard(getPositionOnBoard());
                        return getPositionOnBoard();
                    }
                        setPositionOnBoard(getPositionOnBoard());
                        return getPositionOnBoard();
                    } else {
                    setPositionOnBoard(nextPosition);
                    return nextPosition;
                }
            }
        }
        setPositionOnBoard(null);
        return null;
    }
}
