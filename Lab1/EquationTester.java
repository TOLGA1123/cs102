import java.util.Scanner;
public class EquationTester {
    public static void main(String[] args) {
        //test reduceEquation() method
        Equation equation1 = new Equation(5,10,10);
        Equation equation2 = new Equation(2,-4,2);
        System.out.println(equation1);
        System.out.println(equation2);
        equation1.reduceEquation();
        equation2.reduceEquation();
        System.out.println(equation1);
        System.out.println(equation2);

        //some example test cases with reduceEquation method
        Equation equation3 = new Equation(2431,102,595);
        Equation equation4 = new Equation(208,-368,1276); 
        Equation equation5 = new Equation(-7038,2646,558);
        Equation equation6 = new Equation(28,3,25);

        equation3.reduceEquation();
        equation4.reduceEquation();
        equation5.reduceEquation();
        equation6.reduceEquation();

        System.out.println(equation3);
        System.out.println(equation4);
        System.out.println(equation5);
        System.out.println(equation6);
    // test for equationAdd() and equationSubtract() methods
    Scanner in = new Scanner(System.in);
    System.out.println("Enter the value of a, b and c for the first equation: ");
    int a1 = in.nextInt();
    int b1 = in.nextInt();
    int c1 = in.nextInt();
    Equation eq1 = new Equation(a1,b1,c1);
    System.out.println("Enter the value of a, b, c for the second equation: ");
    int a2 = in.nextInt();
    int b2 = in.nextInt();
    int c2 = in.nextInt();
    Equation eq2 = new Equation(a2,b2,c2);
    System.out.println(eq1);
    System.out.println(eq2);
    // equationAdd() method
    System.out.println("Added equation1 to equation 2: " + eq1.equationAdd(eq2));
    //equationSubtract method
    System.out.println("Subtracted equation2 from equation1: " + eq1.equationSubtract(eq2));
    // test for equals() method 
        Equation eq3 = new Equation(2,3,4);
        Equation eq4 = new Equation(4,6,8);
        System.out.println(eq3);
        System.out.println(eq4);
        System.out.println(eq3.equals(eq4));
    }
}
