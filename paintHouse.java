package leetcode;
/*
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue, green or purple. 
 * The cost of painting each house with a certain color is different. You have to paint all the houses such that 
 * no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 4 cost matrix. 
For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of 
painting house 1 with color green, and so on... Find the minimum cost to paint all houses.
 *
 * Solution:
 * Take the color eg. 0 and add the cost of min of other two colors. From the last row take the min of 3 which will give
 * us min cost to paint all houses. 
 * MAIN concept: Choose min from prev row and exclude the current column from min.
 * */
public class paintHouse {
	public int minCost(int[][] cost){
		if(cost.length==0)
			return 0;
		for(int i=1;i<cost.length;i++){
			cost[i][0] += Math.min(Math.min(cost[i-1][1],cost[i-1][2]),cost[i-1][3]);
			cost[i][1] += Math.min(Math.min(cost[i-1][0],cost[i-1][2]),cost[i-1][3]);
			cost[i][2] += Math.min(Math.min(cost[i-1][0],cost[i-1][1]),cost[i-1][3]);
			cost[i][3] += Math.min(Math.min(cost[i-1][0],cost[i-1][1]),cost[i-1][2]);
		}
		int len = cost.length-1;
		return Math.min(Math.min(cost[len][0], cost[len][1]),cost[len][2]);
	}
}
