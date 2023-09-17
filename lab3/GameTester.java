import java.util.*;
public class GameTester {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter difficulty level(1=EASY, 2=MEDIUM, 3= HARD): " );
        int difficulty = in.nextInt();
        Game game = new Game(difficulty);
        game.play();  // it replaces destructed ones with new vehicle with +1 moved all times
    }
    
}
