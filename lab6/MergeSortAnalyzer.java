public class MergeSortAnalyzer extends SortAnalyzer{
    
    @Override
    public Comparable[] sort(Comparable[] arr) {
        if(arr.length <= 1){
            return arr;
        }
        Comparable[] first = new Comparable[arr.length/2];
        Comparable[] second = new Comparable[arr.length - first.length];
        //copying first and second half
        for(int i = 0; i<first.length; i++){
            first[i] = arr[i];
        }
        for(int i = 0; i<second.length; i++){
            second[i] = arr[first.length+i];
        }
        sort(first);
        sort(second);
        merge(first,second,arr);
        return arr;
    }
    public void merge(Comparable[] first, Comparable[] second, Comparable[] arr){
        int iFirst = 0;
        int iSecond = 0;
        int j = 0;
        while(iFirst<first.length && iSecond<second.length){
            if(compare(first[iFirst],second[iSecond]) <0){
                arr[j] = first[iFirst];
                iFirst++;
            }
            else{
                arr[j] = second[iSecond];
                iSecond++;
            }
            j++;
        }
        //copying remainings
        while(iFirst < first.length){
            arr[j] = first[iFirst];
            iFirst++;
            j++;
        }
        while(iSecond < second.length){
            arr[j] = second[iSecond];
            iSecond++;
            j++;
        }
    }
}
