public class QuickSortAnalyzer extends SortAnalyzer{

    @Override
    public Comparable[] sort(Comparable[] arr) {
        return QuickSort(arr,0,arr.length-1);
    }
    public Comparable[] QuickSort(Comparable[] arr, int from, int to){
        if(from >= to){
            return arr;
        }
        int p = partition(arr,from,to);
        QuickSort(arr,from,p);
        QuickSort(arr,p+1,to);
        return arr;
    }
    private int partition(Comparable[] arr, int from, int to){
        int pivot = (int) arr[from];
        int i = from -1;
        int j = to +1;
        while(i<j){
            i++; while(compare(arr[i], pivot) <0){ i++;
            }
            j--; while(compare(arr[j],pivot) >0){ j--;
            }
            if(i<j){
                int temp = (int) arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return j;
    }
    
}
