package math;

import java.util.Scanner;

public class MakePyramid {
    public static void main(String[] args) {

        //   Implement a large Pyramid of stars in the screen with java.
        //
        //               12345*
        //               1234* *
        //               123* * *
        //               12* * * *
        //               1* * * * *
        //               * * * * * *

        //Start Here
        Scanner sc = new Scanner(System.in);
        int userInput = 0;
        boolean isNumber;

        System.out.print("Enter A Number: ");

        do {
            if (isNumber = sc.hasNextInt()) {
                userInput = sc.nextInt();
            } else {
                System.err.print("\nOnly Digit Numbers...\n\nEnter A Number: ");
                sc.next();
            }
        } while (!isNumber);

        makePyramid(userInput);
    }

    private static void makePyramid(int n){
        int space = n-1, pattern = 0;
        while(space>=0 && pattern<n) {
            System.out.print(makePyramidSpacePerLine(space));
            System.out.println(makePyramidPattern(pattern+1));
            space--;
            pattern++;
        }
    }

    private static String makePyramidSpacePerLine(int n){
        if(n==0) return "";
        String makeSpace = "";
        for(int space=0; space < n; space++) makeSpace += " ";
        return  makeSpace;
    }

    private static String makePyramidPattern(int n){
        if(n==1) return "*";
        return "* "+makePyramidPattern(n-1);
    }
}