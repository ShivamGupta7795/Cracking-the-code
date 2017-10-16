package leetcode;
/*
 * Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.

Substrings that occur multiple times are counted the number of times they occur.

Example 1:
Input: "00110011"
Output: 6
Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".

Notice that some of these substrings repeat and are counted the number of times they occur.

Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
Example 2:
Input: "10101"
Output: 4
Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
 * */
public class binarySubstring {
	 public int countBinarySubstrings(String s) {
	        StringBuilder sb = new StringBuilder();
	        char[] ch = s.toCharArray();
	        int count =0, zeros = 0, ones = 0;
	        
	        if(ch[0]=='0') zeros++;
	        else ones++;
	            
	        for(int i=1;i<ch.length;i++){
	            if(ch[i]!=ch[i-1]){
	                count++;
	                if(ch[i]=='0')
	                    zeros = 1;
	                else
	                    ones = 1;
	            }else{
	                if(ch[i]=='0'){
	                    zeros++;
	                    if(ones>=zeros)
	                        count++;
	                }
	                else{
	                    ones++;
	                    if(zeros>=ones)
	                        count++;
	                }
	            }
	        }
	        
	        return count;
	    }
}
