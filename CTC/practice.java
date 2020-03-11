package CTC;

import java.util.ArrayList;

public class practice {
	public static void main(String ar[]){
		//System.out.println(new practice().isPermutation("shivam", "masvig"));
		ArrayList<Integer> list = new practice().KMPSearch("AABA","AABAACAADAABAABA");
		for(int i:list)
			System.out.println(i);
	}
	public static boolean isPermutation(String s1, String s2){
		if(s1.length()!=s2.length())
			return false;
		
		int[] check = new int[26];
		
		for(char c: s1.toCharArray()){
			check[c-'a']++;
		}
		
		for(char c:s2.toCharArray()){
			check[c-'a']--;
		}
		
		for(int i=0;i<26;i++){
			if(check[i]!=0)
				return false;
		}
	
		
		return true;
		
	}
	
	public ArrayList<Integer> naivePatternSearch(String pattern, String str){
		int p = pattern.length();
		int s= str.length();
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i=0;i<=s-p;i++){
			for(int j=0;j<p;j++){
				if(pattern.charAt(j)!=str.charAt(i+j)){
					break;
				}
				if(j==(p-1))
					result.add(i);
			}
		}
		return result;
	}
	
	public ArrayList<Integer> KMPSearch(String pattern, String str){
		int[] lps = new int[pattern.length()];
		new practice().preprocessLPS(pattern, lps);
		
		int i=0, j=0;
		ArrayList<Integer> result = new ArrayList<Integer>();
		while(i<str.length()){
			if(str.charAt(i)==pattern.charAt(j)){
				i++;
				j++;
				if(j==(pattern.length()-1)){
					result.add(i-pattern.length()+1);
					j= 0;
				}
			}else if(i<str.length() && str.charAt(i)!=pattern.charAt(j)){
				if(j!=0)
					j = lps[j-1];
				else
					i++;
			}
		}
		return result;
	}
	
	public void preprocessLPS(String pattern, int[] lps){
		int i=1, j=0;
		
		while(i<pattern.length()){
			if(pattern.charAt(i)==pattern.charAt(j)){
				j++;
				lps[i] = j;
				i++;
			}else{
				if(j!=0){
					j = lps[j-1];
				}else{
					lps[i] = 0;
					i++;
				}
			}
		}
	}
	
}
