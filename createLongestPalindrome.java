package leetcode;
import java.util.*;
/*Given a string which consists of lowercase or uppercase letters, find the length of the longest
 * palindromes that can be built with those letters.*/
public class createLongestPalindrome {
	 public int longestPalindrome(String s) {
		 char[] ch = s.toCharArray();
	        HashSet<Character> set = new HashSet<Character>();
	        int count = 0;
	        for(char c: ch){
	            if(set.contains(c)){
	                set.remove(c);
	                count++;
	            }else{
	                set.add(c);
	            }
	        }
	        return set.isEmpty()?count*2:(count*2)+1;
	 }
}
