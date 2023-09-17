public class StringEquation {
    public static void main(String[] args) {
        String first = "car";
        String second = "race";
        System.out.println(findMinOperation(first,second,first.length(),second.length()));
    }
    public static int findMin(int add, int remove, int substitute){
        if(add<=remove && add<=substitute){
            return add;
        }
        if(remove<=add && remove<=substitute){
            return remove;
        }
        if(substitute<=add && substitute<=remove){
            return substitute;
        }
        else{
            return -1;
        }
    }
    public static int findMinOperation(String a, String b, int m, int n){
        //if first string is empty, add all characters of second string to first
        if(m==0){
            return n;
        }
        //if second string is empty, remove all characters from the first
        if(n==0){
            return m;
        }
        //if last characters of first and second string are same, ignore them and get count for remaining
        if(a.charAt(m-1)==b.charAt(n-1)){
            return findMinOperation(a,b,m-1,n-1);
        }
        //if last characters aren't same, consider all three operations to find min
        int solution = 1 + findMin(findMinOperation(a,b,m,n-1), //add
        findMinOperation(a,b,m-1,n),findMinOperation(a,b,m-1,n-1)); //remove, substitute
        return solution;
    }
}

