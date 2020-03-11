package CTC;

import java.util.ArrayList;

//find all the prime factors of a given number
public class PrimeFactors {
	
	public ArrayList findPrimeFactors(int n){
		ArrayList<Integer> primeFactors = new ArrayList<>();
		int sqrt = (int)Math.sqrt(n);
		while(n%2==0) {
			primeFactors.add(2);
			n = n/2;
		}
		
		//n is odd now and all the prime factors of n lies below sqrt(n)
		for(int i = 3; i <= sqrt; i+=2) {
			while(n%i==0) {
				primeFactors.add(i);
				n = n/i;
			}
		}
		
		//if a*b = n then both of them can't be greater than sqrt(n)
		/*This property can be proved using counter statement. 
		 * Let a and b be two factors of n such that a*b = n. 
		 * If both are greater than √n, then a.b > √n, * √n, 
		 * which contradicts the expression “a * b = n”.*/
		if(n > 2)
			primeFactors.add(n);
		
		return primeFactors;
	}
	
	public static void main(String[] ar) {
		ArrayList<Integer> list = new PrimeFactors().findPrimeFactors(26);
		
		for(int i: list)
			System.out.println(i);
	}
}
