import java.util.Scanner;
import java.util.Arrays;
public class GameFinder {
    public static void main(String[] args) {
        Game games[] = new Game[]{new Game("Game A", 45, 50), new Game("Game B", 10, 85),
        new Game("Game C", 15, 45), new Game("Game D", 20, 100), new Game("Game E", 25,6),
        new Game("Game F", 100,100)};
        Scanner in = new Scanner(System.in);
        System.out.println("Enter N: "); // 150 100 0 
        int N = in.nextInt();
        int[] selected = new int[games.length];
        System.out.println("Max score: " + findMaxDownload(N,games,games.length,selected));
        for(int i=0; i<games.length; i++){
            if(selected[i]==1){
                System.out.println(games[i]);
            }
        }
    }
    //can download each game at most once
    public static int findMaxDownload(int N, Game[] games, int n, int[] selected){
        //ArrayList<Integer> selectedGames = new ArrayList<Integer>(); // should be storing selected games
        //??? selectedGames.add()
        //base case
        if(n==0 || N==0){
            return 0;
        }
        //whether can download nth game
        if(games[n-1].getStorage()>N){
            return findMaxDownload(N, games, n-1,selected);
        }
        //max of nth game included or not included
        else{
            int[] arr1 = Arrays.copyOf(selected,selected.length);
            int[] arr2 = Arrays.copyOf(selected,selected.length);
        
            arr1[n-1] = 1;
            int result1 = games[n-1].getScore() + findMaxDownload(N-games[n-1].getStorage(),games, n-1,arr1);
            int result2 = findMaxDownload(N,games,n-1,arr2);
            int max = Math.max(result1,result2);
            if(max==result1){
                System.arraycopy(arr1,0,selected,0,arr1.length);
                return result1;
            }
            else{
                System.arraycopy(arr2,0,selected,0,arr2.length);
                return result2;
            }

        }
        //max of nth item included or not included
        /*else{
            return Math.max(games[n-1].getScore()+ findMaxDownload(N-games[n-1].getStorage(),games,n-1,selected),
            findMaxDownload(N,games,n-1,selected));  
        }*/
    }
    
}
