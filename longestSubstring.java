package leetcode;
import java.util.HashMap;
/*Problem:
 * Given a string, find the length of the longest substring without repeating characters.
Examples:
Given "aabcbaa", the answer is "cba", with the length of 3. Note that the answer must be a substring, not a subsequence.
 * Approach:
Add the characters and their position to the map. If a character repeats then the length of the new string becomes
maximum of the (current length of the substring) or (current pointer - (index of repetitive character))+1. Max will store maximum of 
length of such substrings.*/
public class longestSubstring{
	public int lengthOfLongestSubstring(String s) {
	       int length = 0, max= 0;
	        char[] charArray = s.toCharArray();
	        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	        for(int i=0;i<charArray.length;i++){
	            if(map.containsKey(charArray[i])){
	                length = Math.max(length, map.get(charArray[i])+1);
	            }
	            
	            map.put(charArray[i],i);
	            max = Math.max(max,i-length+1);
	        }
	        return max;
	    }
}