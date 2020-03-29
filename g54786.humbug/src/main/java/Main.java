import g54786.humbug.controller.Controller;
import g54786.humbug.model.Game;
import g54786.humbug.view.text.View;

/**
 * Main class for Humbug game.
 * 
 * @author Gregoy van der Pluijm <54786@etu.he2b.be>
 */
public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(new Game() {}, new View() {});
        try {
            controller.startGame();
        } catch (NullPointerException GameOver) {
            System.out.println("Game Over!");
        }

    }
    
}
