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
    /**
     * Moves Ladybird in given direction.
     * @param board Board on which the ladybug must move.
     * @param direction Direction in which the ladybug must move.
     * @param animals All animals on the board.
     * @return New position after the ladybug moved.
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
 
        Position nextPosition = getPositionOnBoard().next(direction);
        int index = 0;

        while (board.isInside(nextPosition) && index !=3) {
            for (Animal animal : animals) {
                if (animal.getPositionOnBoard().equals(nextPosition)) {
                    if (board.getSquareType(getPositionOnBoard()) 
                            == SquareType.STAR) {
                        setOnStar(true);
                        setPositionOnBoard(getPositionOnBoard());
                        board.setSquareType(getPositionOnBoard(), 
                                SquareType.GRASS);
                        return getPositionOnBoard();
                    }
                    setPositionOnBoard(getPositionOnBoard());
                    return getPositionOnBoard();
                }
            }
            setPositionOnBoard(nextPosition);
            nextPosition = getPositionOnBoard().next(direction);
            index++;
            if (index == 2){
                if (board.getSquareType( getPositionOnBoard()) == SquareType.STAR){
                    setOnStar(true);
                    board.setSquareType(getPositionOnBoard(), SquareType.GRASS);
                    setPositionOnBoard(getPositionOnBoard());
                    return getPositionOnBoard();
                    
                }
                setPositionOnBoard(getPositionOnBoard());
                return getPositionOnBoard();
            }
            
        }
        setPositionOnBoard(null);
        return null;
     }
}
