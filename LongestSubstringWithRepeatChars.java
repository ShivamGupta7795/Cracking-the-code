package leetcode;
/*
 * Find the length of the longest substring T of a given string (consists of lowercase letters only) such 
 * that every character in T appears no less than k times.
eg. str = ababacb k=3
output: 5  since "ababa" with 3 a's.
str = ababd k=2;
output 4 as "abab" is of length 4 with 2 'a' and 2 'b'.
*/
public class LongestSubstringWithRepeatChars {
	 
    /*EASY TO UNDERSTAND*/
//     public int longestSubstring(String s, int k) {
//         return helper(s,k,0,s.length());
//     }
//     public int helper(String s, int k, int start, int end){
//         if(end-start<k){
//             return 0;
//         }
//         int[] count = new int[26]; 
//         /*Count the repetations of the characters in the given substring of length end-start*/
//         for(int i=start;i<end;i++){
//             count[s.charAt(i)-'a']++;
//         }
        
//         for(int i=0;i<26;i++){
//             if(count[i]>0 && count[i]<k){
//                 for(int j=start;j<end;j++){
//                     if(s.charAt(j)==i+'a'){
//                          int left = helper(s,k,start,j);
//                         int right = helper(s,k,j+1,end);
//                         return Math.max(left,right);
//                     } 
//                 }
//             }
//         }
//         return end-start;
//     }
    /*BETTER APPROACH*/
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        char[] chars = new char[26];
        // record the frequency of each character
        for (int i = 0; i < s.length(); i += 1) chars[s.charAt(i) - 'a'] += 1;
        boolean flag = true;
        for (int i = 0; i < chars.length; i += 1) {
            if (chars[i] < k && chars[i] > 0) flag = false;
        }
        // return the length of string if this string is a valid string
        if (flag == true) return s.length();
        int result = 0;
        int start = 0, cur = 0;
        // otherwise we use all the infrequent elements as splits
        while (cur < s.length()) {
            if (chars[s.charAt(cur) - 'a'] < k) {
                result = Math.max(result, longestSubstring(s.substring(start, cur), k));
                start = cur + 1;
            }
            cur++;
        }
        result = Math.max(result, longestSubstring(s.substring(start), k));
        return result;
    }
}
