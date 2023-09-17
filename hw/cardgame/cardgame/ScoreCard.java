package cardgame;
import java.util.ArrayList;
// ScoreCard - Maintains one integer score per player, for any number of players
//             Caution: invalid playernumbers result in run-time exception!
// author:
// date:
public class ScoreCard
{
    // properties
    int[] scores;
    
    // constructors
    public ScoreCard( int noOfPlayers)
    {
        scores = new int[noOfPlayers];
        
        // init all scores to zero
        for ( int i = 0; i < scores.length; i++)
            scores[i] = 0;
    }
    
    // methods
    public int getScore( int playerNo)
    {
        return scores[ playerNo];
    }
    
    public void update( int playerNo, int amount)
    {
        scores[playerNo] += amount;
    }
    
    public String toString()
    {
        String s;
        s = "\n"
            + "_____________\n"
            + "\nPlayer\tScore\n"
            + "_____________\n";
        
        for ( int playerNo = 0; playerNo < scores.length; playerNo++)
        {
            s = s + (playerNo+1) + "\t" + scores[playerNo] + "\n";
        }
        
        s += "_____________\n";
        return s;
    }
    // Getting the winners of the game
    public int[] getWinners()
    {
        // ToDo +
        //return null;
        int maxScore = 0;
        ArrayList<Integer> Winners = new ArrayList<Integer>();
        //finding the max score 
        for(int i=0; i<scores.length; i++){
            if(scores[i] > maxScore){
                maxScore = scores[i];
            }
        }
        //Adding the player who wins in an arrayList
        for(int i=0; i<scores.length; i++){
            if(scores[i] == maxScore){
                Winners.add(i);
            }
        }
        //Transfering ArrayList elements to an Array
        int winners[] = new int[Winners.size()];
        for(int i = 0; i<winners.length; i++){
            winners[i] = Winners.get(i);
        }
        return winners;
    }
    
} // end class ScoreCard
