package CTC;
/*This is a coin change problem, in which a sorted set of coins is given along with a target value. Find the number of ways
 * to achieve the target using combination of given coins. A coin value can be repeated any number of times. We used 
 * memoization and dynamic programming for this problem. Approach this problem as follows:
 * Subtract the amount from total amount i.e. money and pass the remainder to next value of coin. Repeat the same process
 * until the amount becomes >= to money. If amount>money then there is 0 ways to reach target using that combination, if 
 * amount == 0 then we have found a combination to achieve the target. Also if the index of coins array < number of repetitions
 * then return 0. 
 * So for this example when we start with a target of 25, subtract 0 and pass the remainder to next index i.e. 10. Now target for next 
 * index is 25 which again subtract 0 and pass it on until it gets something in return from next indices. After a point the
 * '10' will get 0 in return from 20 and after that it'll add the it's own value to the amount and compute a new remainder,
 * which is then passed to the next index as a target. This process will repeat until we get amount>money for the first 
 * index.*/
public class Coin_Change {
	public static void main(String[] ar){
		int[] coins = {5,10,20};
		System.out.println(new Coin_Change().coinchange(25,coins));
	}
//	public long coinchange(int money, int[] coins){
//		if(money==0){return 1;}
//		return coinchange(money,coins,0);
//	}
//	private long coinchange(int money, int[] coins, int index){
//		if(money==0){
//			return 1;
//		}
//		if(index>=coins.length){return 0;}
//		int amount = coins[index];
//		long ways = 0;
//		while(amount<=money){
//			int remainder = money - amount;
//			System.out.println("money: "+money+" remainder:"+remainder+" amount:"+amount+" ways:"+ways+" index:"+index);
//			ways += coinchange(remainder, coins, index+1);
//			amount += coins[index];
//		}
//		return ways;
//	}
	public int coinchange(int amount, int[] coins){
		int[] DP = new int[amount+1];
	    DP[0] = 1;
	    
	    for(int coin: coins){
	        for(int i=coin;i<=amount;i++){
	            DP[i] += DP[i-coin];
	        }
	    }
	    return DP[amount];
	}
}
