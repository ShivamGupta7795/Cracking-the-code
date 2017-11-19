package leetcode;
import java.util.ArrayList;
import java.util.Arrays;
/*Given an array of integers nums and a positive integer k, find whether it's possible to divide this array 
into k non-empty subsets whose sums are all equal.

Example 1:
Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
Output: True
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.

Solution: Use DFS to mark visited elements and check if k subsets can be formed with equal sum.
*/

public class KSubsetEqualSum {
	public static void main(String[] ar){
		KSubsetEqualSum ob = new KSubsetEqualSum();
		System.out.println(ob.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
	}
	
	public boolean canPartitionKSubsets(int[] nums, int k) {
		int sum=0;
		for(int num:nums){
		    sum += num;
		}
		if(sum%k!=0) return false;
		int target = sum/k;
		HashSet<Integer> visited = new HashSet<Integer>();
		return canPartition(nums, k, target, visited, 0, 0);
    	}
    
   public boolean canPartition(int[] nums, int k, int target, HashSet<Integer> visited, int start, int sum){
        if(k==1) return true;
        if(target==sum) return canPartition(nums, k-1, target, visited, 0, 0);
      	for(int i=start;i<nums.length;i++){
          if(!visited.contains(i)){
              visited.add(i);
            if(canPartition(nums, k, target, visited, i+1, sum+nums[i])){
                return true;
            }
              visited.remove(i);
          }    
      }
        return false;
    }
}

