package math;

/**
 * Created by mrahman on 04/22/17.
 */
public class FindMissingNumber {

    public static void main(String[] args) {
        /*
         * If n = 10, then array will have 9 elements in the range from 1 to 10.
         * For example {10,2,1, 4, 5, 3, 7, 8, 6}. One number will be missing in array (9 in this case).
         * Write java code to find the missing number from the array. Write static helper method to find it.
         */
         int [] array = {10, 2, 1, 4, 5, 3, 7, 8, 6};
        String print = print(array);
        int missingValue = arraySort_FindValue(array);
        System.out.println("From the original list: "+print+"\n\nThe missing value is "+missingValue+".");
    }

    private static int arraySort_FindValue(int [] a){
        for(int i=1; i<a.length; i++){//for loop
            int head = a[i];
            int j=i-1;
            while(j>=0 && head < a[j]){
                int temp = a[j];
                a[j] = a[j+1];
                a[j+1] = temp;
                j--;
            }
        }
        int value = 0;
        for(int i=0; i<a.length-1; i++){
            value = a[i];
            if(value+1!=a[i+1])value++;
        }
        return value;
    }

    private static String print(int [] a){
        int n = a.length;
        String in = "[";
        for(int print = 0; print<n; print++){
            if(n-1==print) in += a[print]+"]";
            else in += a[print]+" ";
        }
        return in;
    }
}
