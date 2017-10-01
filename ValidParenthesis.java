package leetcode;
import java.util.Stack;
public class ValidParenthesis {
	/*Both approaches have same running time*/
	    public boolean isValid(String s) {
	        // if(s.charAt(0)==')'|| s.charAt(0)=='}' || s.charAt(0)==']' )
	        //     return false;
	        // Stack<Character> stack = new Stack<Character>();
	        // HashMap<Character, Character> map = new HashMap<Character,Character>();
	        // map.put(')','(');
	        // map.put('}','{');
	        // map.put(']','[');
	        // for(char c:s.toCharArray()){
	        //     if(c=='(' || c=='{' || c=='['){
	        //         stack.push(c);
	        //     }else{
	        //         if(!stack.isEmpty()){
	        //             char ch = stack.pop();
	        //             if(map.get(c)!=ch)
	        //                 return false;
	        //         }
	        //         else
	        //             return false;
	        //     }
	        // }
	        //
	        // return stack.isEmpty();
	        Stack<Character> stack = new Stack<Character>();
	        for (char c : s.toCharArray()) {
	            if (c == '(')
	                stack.push(')');
	            else if (c == '{')
	                stack.push('}');
	            else if (c == '[')
	                stack.push(']');
	            else if (stack.isEmpty() || stack.pop() != c)
	                return false;
	        }
	        return stack.isEmpty();
	  }
}
