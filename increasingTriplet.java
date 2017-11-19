package leetcode;
/*Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
Your algorithm should run in O(n) time complexity and O(1) space complexity.

Examples:
Given [1, 2, 3, 4, 5],
return true.


*/
public class increasingTriplet {
	 public boolean increasingTriplet(int[] nums) {
	        int small =Integer.MAX_VALUE, big = Integer.MAX_VALUE;
	        for(int i:nums){
	            if(i<=small) {small = i;}
	            else{
	                 if(i<=big){ big = i;}
	                else{
	                    return true;
	                }
	            }
	               
	        } 
	        return false;
	    }
}
