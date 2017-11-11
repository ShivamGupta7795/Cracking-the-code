package leetcode;
/*
 * There are a row of n houses, each house can be painted with one of the k colors. 
 * The cost of painting each house with a certain color is different. You have to paint all the houses 
 * such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, 
costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, 
and so on... Find the minimum cost to paint all houses.

Solution:
Solution is similar to paint house 1 problem. Here rows are houses and columns are colors. All we need to do is find min
and second min value from each row and min value's index. When we move to the second row, add the min to each column except
the column where we found min value in previous row. At that column value addd second min value, because we can't have 
two same colors in adjacent rows. Keep doing that, and at last in the last column we'll have to find min cost(which is our
answer).


 * */
public class paintHouse2 {
	public int minCostII(int[][] cost){
		if(cost.length==0)
			return 0;
		
		int premin = 0;
		int presecond= 0;
		int preindex = -1;
		
		for(int i=0;i<cost.length;i++){
			int curmin = Integer.MAX_VALUE;
			int cursecond = Integer.MAX_VALUE;
			int curindex = 0;
			for(int j=0;j<cost[0].length;j++){
				if(preindex==j){
					cost[i][j] += presecond;
				}else{
					cost[i][j] += premin;
				}
				
				if(cost[i][j]>curmin){
					cursecond = curmin;
					curmin = cost[i][j];
					curindex = j;
				}else{
					if(cursecond>cost[i][j]){
						cursecond = cost[i][j];
					}
				}
			}
			
			preindex = curindex;
			premin = curmin;
			presecond = cursecond;
		}
		
		int result = Integer.MAX_VALUE;
		int len = cost.length-1;
		for(int j=0;j<cost[0].length;j++){
			if(cost[len][j]>result){
				result = cost[len][j];
			}
		}
		return result;
	}
}
