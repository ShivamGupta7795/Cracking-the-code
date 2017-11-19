package leetcode;
import java.util.Arrays;
/*Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be 
more than one LIS combination, it is only necessary for you to return the length.

*/
public class longestIncreasingSubsequence {
	 public int lengthOfLIS(int[] nums) {
	        if(nums.length<=1) return nums.length;
	        int[] len = new int[nums.length+1];
	        Arrays.fill(len,1);
	        int max = 1;
	        for(int i=1;i<nums.length;i++){
	            for(int j=0;j<i;j++){
	                if(nums[j]<nums[i]){
	                    len[i] = Math.max(len[i], len[j]+1);
	                }
	                max = Math.max(len[i], max);
	            }
	        }      
	    return max;
	    }
}
