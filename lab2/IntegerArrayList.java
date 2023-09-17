import java.util.ArrayList;
public class IntegerArrayList {
    ArrayList<IntegerArray> numbers;
    public IntegerArrayList(ArrayList<String> integerArrays ){
        numbers = new ArrayList<IntegerArray>();
        for(int i = 0; i<integerArrays.size(); i++){
        numbers.add(new IntegerArray(integerArrays.get(i)));
        }
        
    }
    public int getSize(){
        return numbers.size();
    }
    public IntegerArray getIntegerArrayAt(int index){
        return numbers.get(index);
    }
    public void setIntegerArrayAt(int index, IntegerArray intArr){
        numbers.set(index, intArr);
    }
    public void addIntegerArray(String number){
        numbers.add(new IntegerArray(number));
    }
    public void removeIntegerArray(int index){
        numbers.remove(index);
    }
    public void removeIntegerArray(IntegerArray intArr){
        numbers.remove(intArr);
    }
    public int getHalfIndex(){
        int halfIndex = numbers.size()/2;
        return halfIndex;
    }
    //returns minimum IntegerArray at the given interval (compareTo method)
    public String min(int start, int end){
        IntegerArray minimum = numbers.get(start);
        for(int i = start +1; i<=end; i++){
            int compare = minimum.compareTo(numbers.get(i));
            if(compare>0){
                minimum = numbers.get(i);
            }
        }
        String output = "";
        for(int i =0; i<minimum.digits.length; i++){
            output += minimum.getDigit(i);
        }
        return output;
    }

}
