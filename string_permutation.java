import java.util.HashSet;

public class string_permutation {
	public static void main(String[] ar){
		
	}
	/*method 1: Using HashSet*/
	public static boolean checkpermutation(String s1, String s2){
		if(s1.length()!=s2.length()){
			return false;
		}
		HashSet<Character> set = new HashSet<Character>();
		for(char c:s1.toCharArray()){
			set.add(c);
		}
		for(char c:s2.toCharArray()){
			if(!set.contains(c)){
				return false;
			}
		}
		return true;
	}
	/*method 2: Using Arrays*/
	public static boolean checkstrpermute(String s1, String s2){
		if(s1.length()!=s2.length()){
			return false;
		}
		boolean[] check = new boolean[128];
		for(char c: s1.toCharArray()){
			check[c-'A'] = true;
		}
		for(char c:s2.toCharArray()){
			if(!check[c-'a']){
				return false;
			}
		}
		return true;
	}
}
