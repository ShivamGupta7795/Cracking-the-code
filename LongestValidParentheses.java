package leetcode;
import java.util.Stack;
public class LongestValidParentheses {
	 public int longestValidParentheses(String str) {
	        Stack<Integer> stack = new Stack<Integer>();
	        int n = str.length();
	        char[] s = str.toCharArray();
	        int count = 0;
	        for(int i=0;i<n;i++){
	            if(s[i]=='('){
	                stack.push(i);
	            }else{
	                if(!stack.isEmpty()){
	                    if(s[stack.peek()]=='(')
	                        stack.pop();
	                    else
	                        stack.push(i);
	                }else
	                    stack.push(i);
	            }
	        }
	        
	        if(stack.isEmpty())
	            return n;
	        /*Let's count from the last position to the position of last invalid parentheses.
	        Move the pointer to the current invalid parentheses and another pointer to another 
	        invalid parentheses which occurs before the current one*/
	        int a = n;
	        int b=0;
	        while(!stack.isEmpty()){
	            b = stack.pop();
	            count = Math.max(count, a-b-1);
	            a = b;
	        }
	        /*Check if the length from the start of the string to the next invalid parentheses 
	        has length greater than current length*/
	        count = Math.max(count, a);
	        
	       return count;
	    }
}
