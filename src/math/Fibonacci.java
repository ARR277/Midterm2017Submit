package math;

public class Fibonacci {

    private final static int maxNumber = 40;
    public static void main(String[] args) {
        /*
          Write 40 Fibonacci numbers with java.
         */
        long prev = 0, next = 1, temp;
        int i, limit;

        for (i=0; i<(limit=maxNumber); i++){
            if(i==limit-1)System.out.println(prev);
            else{
                if(i>0 && i%10==0)System.out.println();
                System.out.print(prev+" ");
            }
            temp = next;
            next = prev+next;
            prev = temp;
        }


        System.out.println();
        System.out.println("There are now "+i+" fibonacci number.");

    }
}
