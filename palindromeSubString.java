package leetcode;

public class palindromeSubString {
	int count;
	public int countPalindromeSubstring(String s){
		for(int i=0;i<s.length();i++){
			getPalindrome(s, i, i); //for odd length palindrome
			getPalindrome(s, i, i+1); //for even length palindrome
		}
		return count;
	}
	
	public  void getPalindrome(String s, int left, int right){
		while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
			left--;
			right++;
			count++;
		}
	}
	
	public String longestPalindromeSubstring(String s){
		if(s.length()<2) return s;
		int[] res = new int[2];
		for(int i=0;i<s.length();i++){
			res = getPalidrome(s, i, i, res);
			res = getPalidrome(s, i, i+1, res);
		}
		return s.substring(res[0],res[0]+res[1]);
	}
	
	private int[] getPalidrome(String s, int left, int right, int[] res){
		while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
			left--;
			right++;
		}
		
		int len = res[0];
		int index= res[1];
		
		if(len<right-left-1){
			len = right-left-1;
			index = left+1;
		}	
		return new int[]{len, index};
	}
	
}
