import java.util.Random;
public class RandomArrayGenerator implements ArrayGenerator{

    private static Random generator = new Random();

    @Override
    //n = size of the array
    public Integer[] generate(int n) {
        Integer[] arr = new Integer[n];
        //initially creates a decreasing array
        for(int i=0; i<arr.length; i++){
            arr[i] = n;
            n--;
        }
        //shuffles the elements
        Random rand = new Random();
        for(int i=0; i<arr.length; i++){
            int randomIndex = rand.nextInt(arr.length);
            int temp = arr[randomIndex];
            arr[randomIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
    

}
