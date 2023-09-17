package cardgame;

import java.util.Scanner;
import cardgame.*;

// CardGameTest
// author:
// date:
public class CardGameTest
{
    public static void main( String[] args)
    {
        Scanner scan = new Scanner( System.in);
        
        System.out.println( "Start of CardGameTest\n");
        
        // CONSTANTS
        
        // VARIABLES
        Card       c1 , c2;
        Cards      cards;
        ScoreCard  scores;
        Player     player;
        CardGame   game;
        
        // PROGRAM CODE
        
        // test Card class +
        c1 = new Card( 1);
        System.out.println( c1);
        c2 = new Card(2);
        System.out.println(c2);
        System.out.println(c1.compareTo(c2));
        System.out.println(c1.equals(c2));
        System.out.println();
        
        // test Cards class +
        cards = new Cards( true);
        cards.addTopCard( c1);
        cards.testOnlyPrint();  // remove method after testing!
        System.out.println();
        System.out.println("Deck shuffled: ");
        cards.shuffle();
        cards.testOnlyPrint();
        
        // test ScoreCard class +
        scores = new ScoreCard( 4);
        scores.update( 3, 1);
        scores.update( 1, 2);
        System.out.println( "\n" + scores );
        
        // test Player class +
        // ToDo +
        player = new Player("Joe");
        player.add(new Card(19));
        player.add(new Card(20));
        System.out.println();
        System.out.println(player.getName());
        System.out.println(player.playCard());
        
        // test CardGame class too?
        // Todo + ???
        Player player1 = new Player("Furkan");
        Player player2 = new Player("Fuat");
        Player player3 = new Player("Faruk");
        Player player4 = new Player("Frank");
        game = new CardGame(player1, player2, player3, player4);
        System.out.println( game.playTurn(player1, player1.playCard()));
        System.out.println( game.playTurn(player2, player2.playCard()));
        System.out.println( game.playTurn(player3, player3.playCard()));
        System.out.println( game.playTurn(player4, player4.playCard()));
        
        // Once you have all the bits working, complete the MyCardGame program
        // that provides a menu allowing any of the players to play their card,
        // an option to see the score card, and one to quit the game at any time.
        // When the game is over it should print out the winners.
        
        System.out.println( "\nEnd of CardGameTest\n" );
    }
    
} // end of class CardGameTest
