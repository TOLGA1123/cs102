import java.util.Scanner;

public class Apples{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Number of apples (N): ");
        int N = in.nextInt();
        System.out.println("Number of remaining apples (k): ");
        int k = in.nextInt();
        System.out.println("Target day (a): ");
        int a = in.nextInt();
        System.out.println(checkApples(N,k,a));
    }
    //recursive method 2 or 3 apples can be eaten each day
    public static boolean checkApples(int N, int k, int a){
        
        if(N==k && a==0){
            return true;
        }
        else if(N<k || a<0){
            return false;
        }
        else{
            return checkApples(N-2,k,a-1) || checkApples(N-3,k,a-1);
            
        }
    }

}