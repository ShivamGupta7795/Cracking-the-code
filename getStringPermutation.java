package leetcode;

import java.util.ArrayList;

/*get all the permutations of a string.
 * Solution:
 * With each new iteration add the new character at each position in previously generated strings.*/
public class getStringPermutation {
	
	public static void main(String[] ar){
		ArrayList<String> words = new getStringPermutation().findPermutation("1234");
		int count =0;
		for(int i=0;i<words.size();i++){
				System.out.println(++count+" "+words.get(i));
		}
	}
	
	
	public ArrayList<String> findPermutation(String str){
		return 	findPermutation(str, str.length()-1);
	}
	
	private ArrayList<String> findPermutation(String str, int index){
		ArrayList<String> words;
		if(index==0){
			words = new ArrayList<String>();
			words.add(Character.toString(str.charAt(0)));
		}else{
			words =findPermutation(str, index-1);
			ArrayList<String> temp = new ArrayList<String>();
			char ch = str.charAt(index);
			for(String s: words){
				for(int i=0;i<=s.length();i++){
					String newstr = addCharacter(ch,i,s);
					temp.add(newstr);
				}
			}
			return temp;
		}
		return words;
	}
	
	private String addCharacter(char ch, int index, String str){
		String s1 = str.substring(0,index);
		String s2 = Character.toString(ch);
		String s3 = str.substring(index);
		return s1+s2+s3;
	}
	
	
}
