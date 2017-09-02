package problems;

import java.util.Scanner;

/**
 * Created by mrahman on 04/22/17.
 */
public class Anagram {

    public static void main(String[] args) {
        //Write a Java Program to check if the two String are Anagram. Two String are called Anagram when there is
        //same character but in different order.For example,"CAT" and "ACT", "ARMY" and "MARY".

        String in1, in2;
        Scanner sc = new Scanner(System.in);
        System.out.println("Determining Anagram! Enter Two Inputs Below -->\n");
        System.out.print("Input 1: ");
        in1 = sc.nextLine();
        System.out.print("Input 2: ");
        in2 = sc.nextLine();

        System.out.println("Anagram? "+anagram(in1, in2));
    }

    private static boolean anagram(String in1, String in2){
        int max;
        if(in1.length()!=in2.length())return false;
        else if(in2.length()<=0 || in1.length()<=0) return false;
        else max = in1.length();
        char [] in_1 = in1.toCharArray();
        char [] in_2 = in2.toCharArray();
        in_1 = sort(in_1);
        in_2 = sort(in_2);
        for(int i=0; i<max; i++){
            if(in_1[i]!=in_2[i])return false;
        }
        return true;
    }

    private static char [] sort(char [] in){
        for(int i=1; i<in.length; i++){//for loop
            int head = in[i];
            int j=i-1;
            while(j>=0 && head < in[j]){
                char temp = in[j];
                in[j] = in[j+1];
                in[j+1] = temp;
                j--;
            }
        }
        return in;
    }
}
