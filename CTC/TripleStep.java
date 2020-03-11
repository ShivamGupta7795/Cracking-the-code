package CTC;
// a child can hop 1,2,3 stairs at a time. Find number of ways to reach top

import java.util.Arrays;

public class TripleStep {

	public static void main(String[] ar) {
		int n = 10;
		int[] memo = new int[n+1];
		Arrays.fill(memo, -1);
		System.out.println(new TripleStep().countStairs(n, memo));
	}
	
	public int countStairs(int n, int[] memo) {
		
		if(n==0) {
			return 1;
		}
		
		if(n<0) {
			return 0;
		}
		
		if(memo[n] != -1) {
			return memo[n];
		}
		
		memo[n] =  countStairs(n-1, memo) + countStairs(n-2, memo) + countStairs(n-3, memo);
		
		return memo[n];
	}
}
