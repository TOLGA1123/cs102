/* This class represents equations of the form a = bx + c */
// When b = 1 it shows "1x" instead of "x" 
public class Equation{
    //properties
    private int a;
    private int b;
    private int c;
    //constructor
    // The constructor ensures b is non-negative
    public Equation(int a, int b, int c){
        if(b<0){
            this.a = -a;
            this.b = -b;
            this.c = -c;
        }
        else{
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    //methods
    public int getA(){
        return a;
    }
    public int getB(){
        return b;
    }
    public int getC(){
        return c;
    }
    //This method simplifies the equation if the coefficients have a common divisor other than 1.
    public void reduceEquation(){
        int commonFactor = gcd3(a,b,c);
        a = a/commonFactor;
        b = b/commonFactor;
        c = c/commonFactor;
        if(b<0){
            a = -a;
            b = -b;
            c = -c;
        }
    }
    // method for calculating gcd of two integers using Euclidian algorithm
    // a recursive one can also be implemented
    public int gcd(int x, int y){ // take absolute values of x and y to avoid sign issues
        int temp = 0;
        while(y != 0){
            temp = y;
            y = x % y;
            x = temp; 
        }
        return x;
    }
    //This method calculates gcd of 3 integers.
    public int gcd3(int x, int y, int z){
        int t = gcd(x,y);
        return gcd(t,z);
    }
    public Equation equationAdd(Equation eq2){
        int newA = this.getA() + eq2.getA();
        int newB = this.getB() + eq2.getB();
        int newC = this.getC() + eq2.getC();
        Equation newEquation = new Equation(newA, newB, newC);
        newEquation.reduceEquation();
        return newEquation;
    }
    public Equation equationSubtract(Equation eq2){
        int newA = this.getA() - eq2.getA();
        int newB = this.getB() - eq2.getB();
        int newC = this.getC() - eq2.getC();
        Equation newEquation = new Equation(newA, newB, newC);
        newEquation.reduceEquation();
        return newEquation;
    }
    public String toString(){
        if(this.getB() == 0){
            return this.getA() + " = " + this.getC();
        }
        else if(this.getC()==0){
            return this.getA() + " = " + this.getB() + "x";
        }
        else if(this.getC()>0){
            return this.getA() + " = " + this.getB() + "x +" + this.getC();
        }
        else if(this.getC()<0){
            return this.getA() + " = " + this.getB() + "x " + this.getC();
        }
        else{
            return null;
        }
    }
    //This method checks whether two equations are equal.
    /*Creates 2 new equations with similar values in order to 
    compare to equations without changing the originals */
    public boolean equals(Equation eq){
        Equation eq1 = new Equation(this.getA(),this.getB(),this.getC());
        Equation eq2 = new Equation(eq.getA(),eq.getB(),eq.getC());
        eq1.reduceEquation();
        eq2.reduceEquation();
        boolean check = eq1.getA() == eq2.getA() && eq1.getB() == eq2.getB() 
        && eq1.getC() == eq2.getC();
        return check;
    }

}