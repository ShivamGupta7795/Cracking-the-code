package leetcode;
import java.util.Stack;
public class findCharPairs {
	public int charpairs(String s){
		if(!isUpperCase(s.charAt(0))||s.length()==0){
			return -1;
		}
		Stack<Character> stack = new Stack<Character>();
		int index = -1;
		char[] ch = s.toCharArray();
		for(int i=0;i<ch.length;i++){
			if(isUpperCase(ch[i])){
				stack.push(ch[i]);
			}else{
				if(ch[i]==(stack.peek()+32)){
					stack.pop();
					index = i;
				}else{
					return index;
				}
			}
		}
		return index;
	}
	
	public boolean isUpperCase(char ch){
		return Character.isUpperCase(ch);
	}
}
