package CTC;


public class arrays {
	public static void main(String[] arr){
		System.out.println(unique_char("abeed"));
		System.out.println(replacespace(" god damn "));
	}
	
	public static boolean unique_char(String s){
		int check = 0;
		for(char c:s.toCharArray()){
			int val = 1<<(c-'a');
			if((check&val)>0){
				return false;
			}
			check |= val;
		}
		return true;
	}
	
	public static boolean permutestr(String s1, String s2){
		if(s1.length()!=s2.length()){
			return false;
		}
		boolean[] c = new boolean[26];
		for(char c1:s1.toCharArray()){
			c[c1-'a']= true;
		}
		for(char c1:s2.toCharArray()){
			if(!c[c1-'a']){
				return false;
			}
		}
		return true;
	}
	
	public static String replacespace(String s){
		StringBuilder str = new StringBuilder();
		for(char c:s.toCharArray()){
			if(c == ' '){
				str.append("%20");
			}else{
				str.append(c);
			}	
		}
		return str.toString();
	}
	
	public static boolean subString(String s1, String s2){
		if(s2.length()>s1.length()){
			String temp = s2;
			s2 = s1;
			s1 =temp;
		}
		
		boolean b[] = new boolean[26];
		
		for(char c: s1.toCharArray()){
			b[c-'a'] = true;
		}
		
		for(char c: s2.toCharArray()){
			if(!b[c-'a']){
				return false;
			}
		}
		
		return true;
	}
	
}

