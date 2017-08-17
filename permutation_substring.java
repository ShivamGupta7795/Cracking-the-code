import java.util.HashMap;
/*find if a string is a permuted substring of given string
 * Approach: Create a HashMap and Store each char as key and it's count as Value
 * Iterate through substring and check if char is present in map.
 * If char is present in map then reduce its count and delete it on count=0
 * */
public class permutation_substring {
	public static void main(String[] ar){
		
	}
	
	public static boolean isSubString(String s1, String s2){
		if(s2.length()>s1.length()){
			return false;
		}
		HashMap<Character, Integer> map  = new HashMap();
		for(char c:s1.toCharArray()){
			if(map.containsKey(c)){
				int count = map.get(c);
				map.put(c, ++count);
			}else{
				map.put(c, 1);
			}		
		}
		
		for(char c:s2.toCharArray()){
			if(map.containsKey(c)){
				int count = map.get(c);
				count--;
				if(count==0){
					map.remove(c);
				}else{
					map.put(c, count);
				}	
			}else{
				return false;
			}
		}
		return true;
	}
}
