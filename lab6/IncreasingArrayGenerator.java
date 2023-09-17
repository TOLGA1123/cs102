public class IncreasingArrayGenerator implements ArrayGenerator{

    @Override
    public Integer[] generate(int n) {
        Integer[] arr = new Integer[n];
        for(int i=arr.length-1; i>=0; i--){
            arr[i] = n;
            n--;
        }
        return arr;
    }
    
}
