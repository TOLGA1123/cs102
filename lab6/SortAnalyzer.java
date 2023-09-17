public abstract class SortAnalyzer{
    
    private int numberOfComparisons;
    protected int k;

    public int getComparisonNumber(){
        return numberOfComparisons;
    }
    public void setComparisonNumber(int n){
        numberOfComparisons = n;
    }
    protected int compare(Comparable o1, Comparable o2){
        numberOfComparisons++;
        int integer1 = ((Integer) o1).intValue();
        int integer2= ((Integer) o2).intValue();
        return integer1-integer2;
    }
    //checks an array is sorted or not
    public boolean isSorted(Comparable[] arr){
        if(arr.length == 0 || arr.length == 1){
            return true;
        }
        boolean decreasing = true;
        boolean increasing = true;
        for(int i = 1; i<arr.length; i++){
            //decreasing
            if(compare(arr[i-1],arr[i]) > 0){ decreasing = false;}
            //increasing
            if(compare(arr[i-1],arr[i]) < 0){ increasing = false;}
        }
        return decreasing || increasing;

    }
    //sorting method
    public abstract Comparable[] sort(Comparable[] arr);
}
