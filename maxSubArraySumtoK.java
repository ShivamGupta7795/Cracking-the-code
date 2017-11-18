package leetcode;
import java.util.HashMap;
/*
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. 
 * If there isn't one, return 0 instead.

Note:
The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.

Example 1:
Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

*/
public class maxSubArraySumtoK {
	 public int maxSubArrayLen(int[] nums, int k) {
	        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	        int sum = 0, max= 0;
	        for(int i=0;i<nums.length;i++){
	            sum += nums[i];
	            if(sum==k) max = i+1;
	            else{
	                if(map.containsKey(sum-k)) //or k-sum
	                    max = Math.max(max, i-map.get(sum-k));
	            }
	            if(!map.containsKey(sum)) map.put(sum, i); //or -1*sum
	        }
	        return max;
	    }
}
