package leetcode;
/*
 * Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, 
"pwke" is a subsequence and not a substring.
 * 
 * */
public class longestSubstringWithoutRepeatingChars {
	public static void main(String[] ar){
		
	}
	public static int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        int max = 1;
        char[] ch = s.toCharArray();
        for(int i=1;i<s.length();i++){
            int index = sb.indexOf(Character.toString(ch[i]));
            // System.out.println(index+": "+ch[i]);
            //check if the current char has occured before. If so then replace the string to the position of last 
            //occurence of that char
            if(index!=-1){
                sb = sb.replace(0, index+1, "");
                sb.append(ch[i]);
            }else{
                sb.append(ch[i]);
            }
            max = Math.max(max, sb.length());
            // System.out.println(ch[i]+": "+max);
        }
        return max;
    }
}
