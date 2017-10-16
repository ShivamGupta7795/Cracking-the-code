package leetcode;

public class pallindromicSubstring {
	int max, index;
    public String longestPalindrome(String s) {
        if(s.length()<2) return s;
        
        for(int i=0;i<s.length()-1;i++){
            traverse(s, i, i);
            traverse(s, i, i+1);
        }
        return s.substring(index, index+max);
        
    }
    
    public void traverse(String s, int begin, int end){
        while(begin>=0 && end<s.length() && s.charAt(begin)==s.charAt(end)){
            end++;
            begin--;
        }
        
        if(max<end-begin-1){
            max = end-begin-1;
            index = begin+1;
        }
        
    }
}
