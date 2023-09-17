import java.util.Arrays;
public class Tester {
    public static void main(String[] args) {
        RandomArrayGenerator random = new RandomArrayGenerator();
        DecreasingArrayGenerator decrease = new DecreasingArrayGenerator();
        IncreasingArrayGenerator increase = new IncreasingArrayGenerator();
        SortAnalyzer analyze1 = new MergeSortAnalyzer();
        SortAnalyzer analyze2 = new QuickSortAnalyzer(); 
        SortAnalyzer analyze3 = new GeneralizedMergeSortAnalyzer(); //same tests for this
        SortAnalyzer analyze4 = new GeneralizedQuickSortAnalyzer(); // same tests for this
        //random array
        Integer[] arr1 = random.generate(10);

        //decreasing array
        Integer[] arr2 = decrease.generate(10);
        
        //increasing array
        Integer[] arr3 = increase.generate(10);
        
        System.out.println("//////////////////////////////// MERGE SORT ////////////////////////////////");
        System.out.println(Arrays.toString(arr1));
        System.out.println("Is array sorted: " + analyze1.isSorted(arr1));
        analyze1.sort(arr1);
        System.out.println(Arrays.toString(arr1));
        System.out.println("Number of comparisons to merge sort: " + analyze1.getComparisonNumber());
        analyze1.setComparisonNumber(0);
        

        System.out.println(Arrays.toString(arr2));
        System.out.println("Is array sorted: " + analyze1.isSorted(arr2));
        analyze1.sort(arr2);
        System.out.println(Arrays.toString(arr2));
        System.out.println("Number of comparisons to merge sort: " + analyze1.getComparisonNumber());
        analyze1.setComparisonNumber(0);
        
        System.out.println(Arrays.toString(arr3));
        System.out.println("Is array sorted: " + analyze1.isSorted(arr3));
        analyze1.sort(arr3);
        System.out.println(Arrays.toString(arr3));
        System.out.println("Number of comparisons to merge sort: " + analyze1.getComparisonNumber());

        System.out.println("///////////////////////////////////QUICK SORT///////////////////////////////////");

        //random array
        Integer[] arr4 = random.generate(10);
        //decreasing array
        Integer[] arr5 = decrease.generate(10);
        //increasing array
        Integer[] arr6 = increase.generate(10);

        System.out.println(Arrays.toString(arr4));
        System.out.println("Is array sorted: " + analyze2.isSorted(arr4));
        analyze2.sort(arr4);
        System.out.println(Arrays.toString(arr4));
        System.out.println("Number of comparisons to quick sort: " + analyze2.getComparisonNumber()); 
        analyze2.setComparisonNumber(0);

        System.out.println(Arrays.toString(arr5));
        System.out.println("Is array sorted: " + analyze2.isSorted(arr5));
        analyze2.sort(arr5);
        System.out.println(Arrays.toString(arr5));
        System.out.println("Number of comparisons to quick sort: " + analyze2.getComparisonNumber());
        analyze2.setComparisonNumber(0);

        System.out.println(Arrays.toString(arr6));
        System.out.println("Is array sorted: " + analyze2.isSorted(arr5));
        analyze2.sort(arr6);
        System.out.println(Arrays.toString(arr6));
        System.out.println("Number of comparisons to quick sort: " + analyze2.getComparisonNumber());


        System.out.println("////////////////////////GENERALIZED MERGE SORT///////////////////////////");
        Integer[] arr7 = random.generate(10);
        System.out.println(Arrays.toString(arr7));
        analyze3.sort(arr7);
        System.out.println(Arrays.toString(arr7));
        System.out.println("Number of comparisons to generalized merge sort: " + analyze3.getComparisonNumber());
        
        System.out.println("/////////////////////////GENERALIZED QUICK SORT/////////////////////////////");
        Integer[] arr8 = random.generate(10);
        System.out.println(Arrays.toString(arr8));
        analyze4.sort(arr8);
        System.out.println(Arrays.toString(arr8));
        System.out.println("Number of comparisons to generalized quick sort: " + analyze4.getComparisonNumber());
    }
}
