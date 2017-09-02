package math;

public class PrimeNumber {

	public static void main(String[] args) {
		/*
		 * Find list of Prime numbers from number 2 to 1 million.
		 * Try the best solution as possible.Which will take less CPU life cycle.
		 * Out put number of Prime numbers on the given range.
		 *
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 *
		 */
		long number = 1000000;
		long start = 1;
		boolean isPrime;

		while(start!=number){
			start++;
			isPrime = prime(start);
			if(isPrime){
				System.out.print(start);
			}
			if(start!=number && isPrime) System.out.print(" ");
		}

	}

	private static boolean prime(long n){
		int pairs = 0;
		long i = n, j = n;
		while(j>0){
			if(i%j==0)pairs++;
			j--;
		}
		if(pairs!=2)return false;
		return true;
	}

}
