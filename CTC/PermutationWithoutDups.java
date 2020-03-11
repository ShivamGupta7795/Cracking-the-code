package CTC;
import java.util.*;
// permutation of string with unique chars
public class PermutationWithoutDups {
	public static void main(String[] ar) {
		PermutationWithoutDups ob = new PermutationWithoutDups();
		List<String> perms = ob.getPermsWithoutDups("abbd");
		System.out.println("Size: "+ perms.size());
		for(String str: perms) {
			System.out.println(str);
		}
	}
	
	
	public List<String> getPermsWithoutDups(String s) {
		List<String> result = new ArrayList<>();
		getPerms(s, "", result);
		return result;
	}
	
	public void getPerms(String rem, String prefix, List<String> result) {
		if(rem.length() == 0) {
			result.add(prefix);
		}
		HashSet<Character> visited = new HashSet<>();
		for(int i=0;i<rem.length();i++) {
			char ch = rem.charAt(i);
			String str = rem.substring(0,i) + rem.substring(i+1, rem.length());
			if(!visited.contains(rem.charAt(i))) {
				getPerms(str, prefix+ch, result); 
				visited.add(rem.charAt(i));
			}
		}
	}
	
	
}
