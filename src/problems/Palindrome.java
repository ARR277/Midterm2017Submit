package problems;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        /*
          If a String is reversed and it remains unchanged, that is called Palindrome. For example, MOM,DAD,MADAM are
          Palindrome. So write java code to check if a given String is Palindrome or not.
         */
        Scanner sc = new Scanner(System.in);
        System.out.print("Determining Palindrome:\n\nInput: ");
        String delimiter = "[ ]", input = sc.nextLine();

        String [] stringArray = input.split(delimiter);

        for(int i=0; i<stringArray.length; i++) {
            //System.out.println(stringArray[i]);
            System.out.println(stringArray[i] + "\n\tPalindrome? " + palindrome(stringArray[i])+"\n");
        }
    }

    private static boolean palindrome(String input){
        int first = 0, last = input.length()-1;
        if(input.length()==1) return true;
        while(first!=last && first!=last-1){
            if(input.charAt(first)!=input.charAt(last))return false;
            first++;
            last--;
        }
        return true;
    }
}
