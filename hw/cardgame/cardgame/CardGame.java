package cardgame;

import java.util.ArrayList;

// Cardgame
// author:
// date:
public class CardGame
{
    // properties
    Cards             fullPack;
    ArrayList<Player> players;
    ScoreCard         scoreCard;
    Cards[]           cardsOnTable;
    int               roundNo;
    int               turnOfPlayer;
    // constructors
    // creates a game with 4 players
    public CardGame( Player p1, Player p2, Player p3, Player p4)
    {
        // ToDo +
        players = new ArrayList<Player>();
        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);
        //initializing some properties with reasonable values
        roundNo = 1;
        turnOfPlayer = 0;
        //creating a fullPack of cards and shuffle them
        fullPack = new Cards(true);
        fullPack.shuffle();
        scoreCard = new ScoreCard(players.size());
        cardsOnTable = new Cards[players.size()];
        //initializing cardsOnTable array elements 
        for(int i = 0; i<cardsOnTable.length; i++){
            cardsOnTable[i] = new Cards(false);
        } 
        //distributing cards of the deck to the players
        for(int i = 0; i<fullPack.NOOFCARDSINFULLPACK/players.size(); i++){
            for(int j = 0; j<players.size(); j++){
                players.get(j).add(fullPack.getTopCard());
            }
        }

    }
    
    // methods
    public boolean playTurn( Player p, Card c)
    {
        // Todo +
        //return false;
        Card aCard = new Card(0); // a Card instance to compare the values of the played Cards
        if(!isTurnOf(p) || isGameOver()){
            System.out.println("Wrong turn!"); //shows nothing here
            return false;
        }
        else{
            // The player whose turn is on plays his card.
            cardsOnTable[turnOfPlayer].addTopCard(c);
            System.out.println("Player" + (turnOfPlayer+1) + "'s card: " + c.toString());
            if(turnOfPlayer == 3){
                roundNo++; // Update roundNo every round
                for(int i= 0; i< players.size(); i++){
                    //Compares every played card with previous one
                    aCard = new Card(cardsOnTable[i].cards[cardsOnTable[i].valid-1].compareTo(aCard));
                }
                //Giving the score in each round for the player who has the highest value card
                for(int i = 0; i < players.size(); i++){
                    if (cardsOnTable[i].cards[cardsOnTable[i].valid-1].equals(aCard)) { 
                        scoreCard.update(i , 1);
                    }
                }
            }
            turnOfPlayer++;
            turnOfPlayer %=4;
            return true;
        }
    }
    public boolean isTurnOf( Player p)
    {
        // ToDo +
        //return false;
        return players.get(turnOfPlayer).getName().equals(p.getName());
    }
    
    public boolean isGameOver()
    {
        // ToDo +
        //return false;
        // in the last round last player's turn is over
        return roundNo >= 52/players.size();
    }
    
    public int getScore( int playerNumber)
    {
        // ToDo +
        //return -1;
        if(playerNumber < players.size()){
            return scoreCard.getScore(playerNumber);
        }
        else{
            return -1;
        }
    }
    
    public String getName( int playerNumber)
    {
        // ToDo +
        //return "Not yet implemented";
        if(playerNumber < players.size()){
            return players.get(playerNumber).getName();
        }
        else {
            return "Player does not exist";
        }
        
    }
    
    public int getRoundNo()
    {
        // ToDo +
        //return -1;
        return roundNo;
    }
    
    public int getTurnOfPlayerNo()
    {
        // ToDo +
        //return -1;
        return turnOfPlayer;
    }
    
    public Player[] getWinners()
    {
        // ToDo +
        //return null;
        Player[] winners = new Player[scoreCard.getWinners().length];
        for(int i = 0; i<winners.length; i++){
            winners[i] = players.get(scoreCard.getWinners()[i]);
        }
        return winners;
    }
    
    public String showScoreCard()
    {
        return scoreCard.toString();
    }
    
}