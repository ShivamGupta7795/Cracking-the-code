package leetcode;
/*Problem:
 * check if the given string is a valid palindrome with one extra character.
 * Approach:
 * check if the left and right side characters are equal. If not then call checkpalindrome which will check
 * string whether the string after the mismatched character is a palindrome or not. Now this mismatched character can
 * be either on the left or the right side. Therefore, we check string from left+1 to right and left to right-1 length.
 * If either of results in true then rest of the string is a palindrome.*/
public class validpalindrometwo {
	  public boolean validPalindrome(String s) {
	        if(s.length()==0||s.length()==1){
	            return true;
	        }
	        char[] strarray = s.toCharArray(); 
	        for(int l=0,r=strarray.length-1;l<r;l++,r--){
	            if(strarray[l]!=strarray[r]){
	                return checkpalindrome(strarray,l+1,r)|checkpalindrome(strarray,l,r-1);
	            }
	         }
	         return true; 
	       
	    }
	    public boolean checkpalindrome(char[] array,int left, int right){
	        while(left<right){
	            if(array[left]!=array[right]){
	                return false;
	            }
	            left++;
	            right--;
	        }
	        return true;
	    }
}
