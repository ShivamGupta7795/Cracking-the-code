/*unique function returns true if all chars are unique
 * Approach:
 * shift 1 by character-'A' bits.
 * If two chars are same they'll have same position for 1. 
 * 'AND' of two numbers with different position of 1 will result in 0.
 * */
public class unique_char {
	public static void main(String[] ar){
		System.out.println(unique("abcb"));
	}
	public static boolean unique(String str){
		int check = 0;
		for(char c:str.toCharArray()){
			int shift = 1<<c-'A';
			if((check&shift)!=0){
				return false;
			}
			check |= shift;
		}	
		return true;
	}
}
