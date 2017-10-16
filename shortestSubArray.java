package leetcode;
import java.util.HashMap;
/*
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency 
 * of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

Example 1:
Input: [1, 2, 2, 3, 1]
Output: 2
Explanation: 
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.

Example 2:
Input: [1,2,2,3,1,4,2]
Output: 6
 * 
 */
public class shortestSubArray {
	public int findShortestSubArray(int[] nums) {
        HashMap<Integer, int[]> map = new HashMap<Integer, int[]>();
        int len = 0;
        /*In integer array first value is number of occurences, second is first occurence and third is last occurence*/
        int degree = 0, pos = 0;
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i]))
                map.put(nums[i],new int[]{1,i,i});
            else{
                int[] val = map.get(nums[i]);
                map.put(nums[i], new int[]{val[0]+1, val[1], i});
            }
            int[] val = map.get(nums[i]);
            if(val[0]>degree)
                len = val[2] - val[1] + 1;
            else{
                if(val[0]==degree)
                    len = Math.min(val[2] - val[1] + 1, len);
            }
            degree = Math.max(val[0],degree);
        }
        
        return len;
        
    }
}
