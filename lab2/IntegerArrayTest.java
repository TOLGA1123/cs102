import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;
public class IntegerArrayTest {
    public static void main(String[] args) throws Exception {
        IntegerArray arr1 = new IntegerArray("150"); // positive + negative + 0 +
        IntegerArray arr2 = new IntegerArray("1050");
        System.out.println("Number of digits in the first IntegerArray: " + arr1.numberOfDigits());
        System.out.println("Most important digit for the first IntegerArray: " + arr1.MID());
        System.out.println("Least important digit for the first IntegerArray: " + arr1.LID());
        System.out.println("Second index of the first IntegerArray: " + arr1.getDigit(0));
        System.out.println("Adding arr1 and arr2: ");
        for(int i = 0; i<arr1.add(arr2).digits.length; i++){
            System.out.print(arr1.add(arr2).getDigit(i));
        }
        boolean negative = false; boolean nonnegative = false;
        if(arr1.compareTo(arr2)>=0){
            nonnegative = true;
        }
        if(arr1.compareTo(arr2)<0){
            negative = true;
        }
        System.out.println("\nSubtracting arr2 from arr1: ");
        //toString here
        if(negative){String negativeResult = "-";
        int leadingZeroes = 0;
        boolean ZeroesEnd = false;
        int startPoint = leadingZeroes;
        for(int i = 1; i<arr1.subtract(arr2).digits.length; i++){
            if(arr1.subtract(arr2).digits[i] == 0 && !ZeroesEnd){
                leadingZeroes++;
            }
            if(arr1.subtract(arr2).digits[i] != 0){
                ZeroesEnd = true;
            }
            if(leadingZeroes != arr1.subtract(arr2).digits.length && ZeroesEnd){
                negativeResult +=   arr1.subtract(arr2).digits[startPoint+1];
            } 
            startPoint ++; 
        }
        System.out.println(negativeResult);
    }
        if(nonnegative){
        for(int j = 0; j<arr1.subtract(arr2).digits.length; j++){
            System.out.print(arr1.subtract(arr2).getDigit(j));
        } 
    }
        System.out.println("\nTesting compareTo: ");
        System.out.println(arr1.compareTo(arr2));
        System.out.println(arr2.compareTo(arr1));
        IntegerArrayList numbers = readIntegerArraysFromFile(""); // Test1.txt Test2.txt Test3.txt
        // Problems with middle value whether it is odd or even 
        // array with 0 1 2 3 4   half?? 0 1 2 / 2 3 4
        System.out.println("Start: " + 0 + "\nMiddle: " + numbers.getHalfIndex() + "\nEnd: " + (numbers.getSize()-1));
        System.out.println("Minimum of all numbers: " + numbers.min(0, numbers.getSize()-1));   
        System.out.println("Minimum of the first half: " + numbers.min(0, numbers.getHalfIndex()));
        System.out.println("Minimum of the second half: " + numbers.min(numbers.getHalfIndex(), numbers.getSize()-1));
    }
    public static IntegerArrayList readIntegerArraysFromFile(String filename) throws Exception{
        ArrayList<String> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        System.out.println("Please input file name: ");
        String fileName = in.nextLine();
        Scanner scan = new Scanner(new File(fileName));
        while(scan.hasNext() ){
            list.add(scan.nextLine());
        }
        //Test2 ignoring 2 blank lines +
        for(int i = 0; i<list.size(); i++){
            if(list.get(i).equals("")){
                list.remove(i);
            }
        }
        IntegerArrayList numbers = new IntegerArrayList(list);
        return numbers;
    }
}
