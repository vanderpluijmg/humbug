package g54786.humbug.model;

/**
 * Square on the board. A square is or grass or star. A square does not know its
 * location on the board.
 *
 * @author Gregory van der Pluijm <54786@etu.he2b.be>
 */
public class Square {

    private SquareType type;

    /**
     * Constructor of square on board.
     *
     * @param type Square is grass or star.
     */
    public Square(SquareType type) {
        this.type = type;
    }

    /**
     * Setter of SquareType.
     *
     * @param type Type of square to set.
     * @return Set square type.
     */
    public SquareType setType(SquareType type) {
        this.type = type;
        return this.type;
    }

    /**
     * Getter of Square type.
     *
     * @return Type of square.
     */
    public SquareType getType() {
        return type;
    }

}
