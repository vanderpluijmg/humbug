


import g54786.humbug.controller.Controller;
import g54786.humbug.model.Game;
import g54786.humbug.view.text.TerminalColor;
import g54786.humbug.view.text.View;
import java.util.Scanner;

/**
 * Main class for Humbug game.
 *
 * @author Gregoy van der Pluijm <54786@etu.he2b.be>
 */
public class Main {
        
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(TerminalColor.GREEN +
            "--------------WELCOME TO HUMBUG-------------");
        System.out.println("At what level would you like to start (1-40)");
        int level = keyboard.nextInt();
        if (level != 100){
            while (level < 1 || level > 40){
                System.out.println("Enter a valid level");
                level = keyboard.nextInt();
            }
        }
        Controller controller = new Controller(new Game() {}, new View() {});
        try {
            controller.startGame(level);
        } catch (NullPointerException GameOver) {
            System.out.println("You lost!");
        }
    }
}
