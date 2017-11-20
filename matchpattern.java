package leetcode;
import java.util.*;
/*
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty
word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.

*/

public class matchpattern {
    public boolean wordPattern(String pattern, String str) {
        /*Approach:
        Check if length of pattern and token array is same
        Check if both pattern and token array have equal number of distinct elements
        Check if there is any position where values of pattern character and token value differs*/
      HashMap map = new HashMap();
        String[] words = str.split(" ");
        if(words.length!=pattern.length())
            return false;
        HashSet set = new HashSet();
        int charcount= 0;
        int strcount = 0;
        
        for(char c:pattern.toCharArray()){
            if(!set.contains(c)){
                charcount++;
            }
            set.add(c);
        }
        set = new HashSet();
        for(String s: words){
            if(!set.contains(s)){
                strcount++;
                if(strcount>charcount)
                    return false;
            }
            set.add(s);
        }
        if(strcount!=charcount)
            return false;
        
        for(int i=0;i<words.length;i++){
            char key = pattern.charAt(i);
            String val = words[i];
            if(map.containsKey(key)){
                if(!map.get(key).equals(val))
                    return false;
            }
            map.put(key,val);
        }
        return true;
    }  
        
}
/*Approach 2*/
class solution{
	public boolean matchpattern(String pattern, String str){
		String[] words = str.split(" ");
	    if (words.length != pattern.length())
	        return false;
	    Map index = new HashMap();
	    for (Integer i=0; i<words.length; ++i)
	        if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
	            return false;
	    return true;
	}
}
