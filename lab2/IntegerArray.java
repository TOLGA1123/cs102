public class IntegerArray implements Comparable<IntegerArray>{
    //Needs to handle negative numbers as well
    String digit;
    int[] digits;
    private boolean isPositive , isNegative , isZero;
    public IntegerArray(String digit){
        this.digit = digit;
        //avoid leading zeroes in the String
        int leadingZeroes = 0;
        boolean leadingZeroesFinished = false;
        for(int i=0; i<digit.length(); i++){

            if(digit.charAt(i) == '0' && !leadingZeroesFinished){
                leadingZeroes++;
            }
            else if(digit.charAt(i) != '0') {
                leadingZeroesFinished = true;
            }
        }
        if(leadingZeroes != digit.length()){
        digit = digit.substring(leadingZeroes); 
        }
        digits = new int[digit.length()];
        for(int i=0; i<digits.length; i++){
            digits[i] = Character.getNumericValue(digit.charAt(i));  // negative number getNUmericValue - = -1
        }
    }
    //returns the number of digits in the IntegerArray
    public int numberOfDigits(){
        return digits.length;
    }
    //returns most important digit (left)
    public int MID(){
        return getDigit(0);
    }
    //returns least important digit (right)
    public int LID(){
        return digits[numberOfDigits()-1];
    }
    //returns the digit at the given index
    public int getDigit(int index){
        return digits[index];  
    }
    //works fine
    public IntegerArray add(IntegerArray Other){
        int length1 = this.digits.length;
        int length2 = Other.digits.length;
        int sumLength = Math.max(length1,length2);
        int[] sumOfTwoArrays = new int[sumLength];
        int i = length1 -1;
        int j = length2 -1;
        int z = sumLength -1;
        int carry = 0;
        int sum = 0;
        while(j >= 0 || i >= 0){
            sum = 0;
            if(i >= 0){
                sum += this.digits[i];
                i--;
            }
            if(j >= 0){
                sum += Other.digits[j];
                j--;
            }
            sum += carry;
            carry = sum/10;
            sumOfTwoArrays[z] = sum % 10;
            z--;
        }
        if(carry != 0){
            int[] sumOfTwoArrays1 = new int[sumOfTwoArrays.length + 1];
            sumOfTwoArrays1[0] = carry;
            for(int x = 1; x < sumOfTwoArrays1.length; x++){
                sumOfTwoArrays1[x] = sumOfTwoArrays[x-1]; 
            }
            String newDigit1 = "";
            for(int b = 0; b<sumOfTwoArrays1.length; b++){
            newDigit1 += sumOfTwoArrays1[b];
        }
          return new IntegerArray(newDigit1);  
        }
        else{
        String newDigit = "";
        for(int a = 0; a<sumOfTwoArrays.length; a++){
            newDigit += sumOfTwoArrays[a];
        }
        return new IntegerArray(newDigit);
    }
        }
        // cannot handle non-positive values
        //works only if this.digits>Other.digits // some changes // if negative first index -1 cannot remove leading0's
        //Still not clean enough with negative 
    public IntegerArray subtract(IntegerArray Other){
        if(this.compareTo(Other)>0){isPositive = true; isNegative = false; isZero = false;}
        else if(this.compareTo(Other) == 0){isPositive = false; isNegative = false; isZero = true;}
        else{isPositive = false; isNegative = true; isZero = false;}
        if(isPositive){
        int i = this.digits.length -1;
        int j = Other.digits.length -1;
        int borrow = 0;
        int[] diffOfTwoArrays = new int[Math.max(this.numberOfDigits(), Other.numberOfDigits())];
        int z = diffOfTwoArrays.length -1;
        while(i>=0 && j>=0){
            diffOfTwoArrays[z] = this.digits[i] - Other.digits[j] + borrow;
            if(diffOfTwoArrays[z]>=0){
               borrow = 0;
            }
            else{
                diffOfTwoArrays[z] +=10;
                borrow = -1;
            }
            z--;
            j--;
            i--;
        }
        if(i >= 0){
            while(i>=0){
                diffOfTwoArrays[z] = this.digits[i] + borrow;
                if(diffOfTwoArrays[z]>=0){
                    borrow = 0;
                }
                else{
                    diffOfTwoArrays[z] += 10;
                    borrow = -1;
                }
                z--;
                i--;
            }
            if(j >= 0){
                while(j >= 0){
                    diffOfTwoArrays[z] = Other.digits[j] + borrow;
                    if(diffOfTwoArrays[z] >=0){
                        borrow = 0;
                    }
                    else{
                        diffOfTwoArrays[z] += 10;
                        borrow = -1;
                    }
                    z--;
                    j--;
                }
            }
        }
        String newDigit = "";
            for(int a = 0; a<diffOfTwoArrays.length; a++){
                newDigit += diffOfTwoArrays[a];
            }
            return new IntegerArray(newDigit);
        }
        else if(isNegative){
            int i = Other.digits.length -1;
        int j = this.digits.length -1;
        int borrow = 0;
        int[] diffOfTwoArrays = new int[Math.max(Other.numberOfDigits(), this.numberOfDigits())];
        int z = diffOfTwoArrays.length -1;
        while(i>=0 && j>=0){
            diffOfTwoArrays[z] = Other.digits[i] - this.digits[j] + borrow;
            if(diffOfTwoArrays[z]>=0){
                borrow = 0;
            }
            else{
                diffOfTwoArrays[z] +=10;
                borrow = -1;
            }
            z--;
            j--;
            i--;
        }
        if(i >= 0){
            while(i>=0){
                diffOfTwoArrays[z] = Other.digits[i] + borrow;
                if(diffOfTwoArrays[z]>=0){
                    borrow = 0;
                }
                else{
                    diffOfTwoArrays[z] += 10;
                    borrow = -1;
                }
                i--;
                z--;
            }
            if(j >= 0){
                while(j >= 0){
                    diffOfTwoArrays[z] = this.digits[j] + borrow;
                    if(diffOfTwoArrays[z] >=0){
                        borrow = 0;
                    } 
                    else{
                        diffOfTwoArrays[z] += 10;
                        borrow = -1;
                    }
                    j--;
                    z--;
                }
            }
        }
        String newDigit = "";
            for(int a = 0; a<diffOfTwoArrays.length; a++){
                newDigit += diffOfTwoArrays[a];
            }
            newDigit = "-" + newDigit;
            return new IntegerArray(newDigit);
        }
        //Something wrong with leadingZeroes issue
        else if (isZero){
            return new IntegerArray("0");
        }
        return null;
    }
    // if two numbers are 5004 and 5003 it returns 0
    public int compareTo(IntegerArray Other){
        // if numbers have different number of digits
        if(this.digits.length > Other.digits.length){
            return 1;
        }
        else if(this.digits.length < Other.digits.length){
            return -1;
        }
        // if both numbers have same number of digits
        else{
            int i = 0;
            while (i<this.digits.length){
                if(this.digits[i] > Other.digits[i]){
                    return 1;
                }
                else if(this.digits[i]<Other.digits[i]){
                    return -1;
                }
                else{
                    i++;
                    continue; // this solved I guess
                }
                //return 0;
            }
        }
        return 0; 
    }
}
