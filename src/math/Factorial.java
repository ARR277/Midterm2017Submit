package math;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by mrahman on 04/22/17.
 */
public class Factorial {

    public static void main(String[] args) {
        /*
         * Factorial of 5! = 5 x 4 X 3 X 2 X 1 = 120.
         * Write a java program to find Factorial of a given number using Recursion as well as Iteration.
         *
         */
        Scanner sc = new Scanner(System.in);
        boolean isNumber;
        int num = 0;
        System.out.print("Enter A Number To Calculate The Factorial\n\nInput:");

        do{
            if(isNumber = sc.hasNextInt()){
                num = sc.nextInt();
                System.out.println("Calculating.....");
            }
            else {
                System.err.println("Error: Not Integer\nRestarting Application.....");
                System.err.print("Input: ");
                sc.next();
            }
        }while(!isNumber);

        System.out.println("\n\t"+num+"! = "+printFact(num)+factorial(num));
    }

    private static String printFact(int n){
        String in = "";
        while(n>=1){
            if(n==1) in += n+" = ";
            else in += n + " x ";
            n--;
        }
        return in;
    }

    private static int factorial(int n){
        if(n==1)return n;
        return n*factorial(n-1);
    }
}
