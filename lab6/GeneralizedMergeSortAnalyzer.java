public class GeneralizedMergeSortAnalyzer extends SortAnalyzer{

    @Override
    // sort the data by k-way merge sort algorithm
    public Comparable[] sort(Comparable[] arr) {
        return generalMergeSort(arr,0,arr.length-1,5);
    }
    public Comparable[] generalMergeSort(Comparable[] arr, int low, int high, int k){
        Comparable[][] subArrays = new Comparable[k][arr.length/k];
        if(arr.length <= 1){
            return arr;
        }
        for(int i = 0; i<k; i++){
            for(int j = 0; j<arr.length/k; j++){
            subArrays[i][j] = generalMergeSort(arr,i*(arr.length/k),(i+1)*arr.length/k-1,k)[j];
            }

        }
        return merge(subArrays , k);
        
    }
    public Comparable[] merge(Comparable[][] arr, int k){ // merge k sorted subarrays
        int[] index = new int[arr[0].length];
        Comparable[] result = new Comparable[arr.length*arr[0].length];
        for(int i = 0; i<index.length; i++){
            index[i] = 0;
        } 
        int i = 0;
        int j = 0;
        int x = 0;
        while(i<arr[0].length){
            int min = (int) arr[0][0];
            while(j<arr.length){
            if(compare(min,arr[index[i]+1][j])<0){ 
                min = (int) arr[index[i]][j];
                result[x] = min;
                index[i]++;
            }
            }
            x++;
        }
        return result;

    }
    
}
