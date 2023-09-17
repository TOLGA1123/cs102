public class GeneralizedQuickSortAnalyzer extends SortAnalyzer{

    @Override
    public Comparable[] sort(Comparable[] arr) {
        // TODO Auto-generated method stub
        return null;
    }
    public Comparable[] generalizedQuickSort(Comparable[] arr, int from, int to, int k){
        if(from >= to){
            return arr;
        }
        int[] pivots = kpartition(arr,from,to,k);
        for(int i=0; i<pivots.length; i++){
            generalizedQuickSort(arr,from,pivots[i],k);
            generalizedQuickSort(arr,pivots[i]+1,to,k);
        }
        return arr;
    }
    private int[] kpartition(Comparable[] arr, int from, int to, int k){
        int[] pivots = new int[k];
        for(int i = 0; i<k; i++){
            pivots[i] = (int) arr[from];
        }
        
        return pivots;

    }
    
}
