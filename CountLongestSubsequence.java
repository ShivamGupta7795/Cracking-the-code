package leetcode;

public class CountLongestSubsequence {
	    public int findNumberOfLIS(int[] nums) {
	        int[] len = new int[nums.length];
	        int[] count = new int[nums.length];
	        int maxlen = 0, result = 0;
	        
	        for(int i=0;i<nums.length;i++){
	            len[i] = 1; count[i] = 1;
	            for(int j=0;j<i;j++){
	                if(nums[i]>nums[j]){
	                    /*If length of current subsequence is equal to a subsequence which ends with nums[j] 
	                        then add the count of both subsequences.
	                    */
	                    if(len[i]==len[j]+1)
	                        count[i] += count[j];
	                   
	                    
	                    /*If the current subsequence has length 1 less than a subsequence which ends with nums[j] then
	                    increase the length of subsequnce by nums[j]+1 and set the count equals to count of subsequence which
	                    ends nums[j].(But now it ends with nums[i]).
	                    */
	                    if(len[i]<len[j]+1){
	                        len[i] = len[j]+1;
	                        count[i] = count[j];
	                    } 
	                }
	            }
	            /*Check if length of current subsequence(which ends with nums[i]) has length equals of greater than 
	            maxlen*/
	            if(maxlen==len[i]) 
	                result += count[i];
	            if(maxlen<len[i]){
	                maxlen = len[i];
	                result = count[i];
	            }
	        }
	        return result;
	    }
}
