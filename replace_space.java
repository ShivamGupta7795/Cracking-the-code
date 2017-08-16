import java.util.ArrayList;
/*question: replace all the spaces in the string with %20.
 * Catch: Leave the spaces at the end of string.
 * Can not make use of String or StringBuilder.*/
public class replace_space {
	public static void main(String[] ar){
		
	}
	public static char[] replacespace(char[] ch){
		int i=0;
		ArrayList<Character> list= new ArrayList<Character>();
		/*break the loop after rendering spaces from end of array*/
		for(i=ch.length-1;i>=0;i--){
			if(ch[i]!=' '){	
				break;
			}
		}
		
		for(;i>=0;i--){
			if(ch[i] == ' '){
				list.add('0');
				list.add('2');
				list.add('%');
			}else{
				list.add(ch[i]);
			}
		}
		char[] result = new char[list.size()];
		for(i=0;i<list.size();i++){
			result[i] = list.get(i);
		}
		return result;
	}
}
