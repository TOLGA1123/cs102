public class DecreasingArrayGenerator implements ArrayGenerator{

    @Override
    public Integer[] generate(int n) {
        Integer[] arr = new Integer[n];
        for(int i=0; i<arr.length; i++){
            arr[i] = n;
            n--;
        }
        return arr;
    }
    
}
