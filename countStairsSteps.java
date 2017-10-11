package leetcode;
/*count number of ways to climb stair with 1, 2 or 3 steps at a time*/
public class countStairsSteps {
	public int countSteps(int steps){
		return countSteps(steps,new int[steps]);
	}
	private int countSteps(int steps, int[] count){
		if(steps<0) return 0;
		if(steps==0) return 1;
		if(count[steps]!=0) return count[steps];
		count[steps] = countSteps(steps-1, count) + countSteps(steps-2, count) + countSteps(steps-3, count);
		return count[steps];
	}
}
