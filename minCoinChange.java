package leetcode;
import java.util.Arrays;
/*
 You are given coins of different denominations and a total amount of money amount.
 Write a function to compute the fewest number of coins that you need to make up that amount. 
 If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1. 

 */
public class minCoinChange {
	/*iterative way*/
	    public int coinChange(int[] coins, int amount) {
	       int[] min = new int[amount+1];
	        Arrays.fill(min, Integer.MAX_VALUE-1);
	        min[0] = 0;
	        for(int i=1;i<=amount;i++){
	            for(int coin:coins){
	                if(i>=coin && min[i-coin]+1<min[i]) 
	                    min[i] = min[i-coin]+1;
	            }
	            // System.out.println(min[i]+": "+i);
	        }
	        return (min[amount]==Integer.MAX_VALUE-1)?-1:min[amount];
	    }
	    
	  /*recursive way*/
	  int helper(int[] coins, int amount, int[] count) { // amount: remaining coins after the last step; count[rem]: minimum number of coins to sum up to rem
	        if(amount<0) return -1; // not valid
	        if(amount==0) return 0; // completed
	        if(count[amount-1] != 0) return count[amount-1]; // already computed, so reuse
	        int min = Integer.MAX_VALUE;
	        for(int coin : coins) {
	            int res = helper(coins, amount-coin, count);
	            if(res>=0 && res < min)
	                min = 1+res;
	        }
	        count[amount-1] = (min==Integer.MAX_VALUE) ? -1 : min;
	        return count[amount-1];
	    }
	    
	  /*find all the combinations using given coins eg. 5 can be computed in 9 ways:
	    1+1+1+1+1
	    1+1+1+2
	    1+1+2+1
	    1+2+1+1
	    2+1+1+1 and so on*/
//	     int change(int amount, int[] coins, int[] DP){
//	         if(amount<0)
//	             return -1;
	        
//	         if(DP[amount]!=0)
//	             return DP[amount];
	        
//	         for(int i=1;i<=amount;i++){
//	             for(int j=0;j<coins.length;j++){
//	                 if(i>=coins[j])
//	                     DP[i] += change(i-coins[j], coins, DP);
//	             }
//	             System.out.println(DP[i]+" : "+i);
//	         }
//	         return DP[amount];
//	     }
	  
	
}
