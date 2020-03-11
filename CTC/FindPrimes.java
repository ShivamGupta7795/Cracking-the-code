package CTC;

import java.util.ArrayList;

public class FindPrimes {
	
	public ArrayList<Integer> findAllPrimeNumbersInRange(int range) {
		
		ArrayList<Integer> primes  = new ArrayList<>();
		boolean[] isNotPrime = new boolean[range];
		
		if(range<2) return primes;
		primes.add(2);
		
		int upperBound = (int)Math.sqrt(range);
		
		//visit only odd numbers
		for(int i=3; i<=range;i+=2) {
			
			if(isNotPrime[i]) continue;
			primes.add(i);
			
			if(i> upperBound) continue;
			//make sure to visit only odd numbers by increasing j += i*2
			for(int j= i*i; j<range; j+= i*2) {
				isNotPrime[j] = true;
			}
		}
		
		return primes;
	}
	
	
	public static void main(String[] ar) {
		ArrayList<Integer> list = new FindPrimes().findAllPrimeNumbersInRange(50);
		for(int i:list) {
			System.out.println(i);
		}
	}

}
