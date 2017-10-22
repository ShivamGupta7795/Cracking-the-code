package leetcode;

import java.util.ArrayList;
public class patternSearch {
	
	public static void main(String[] ar){
		ArrayList<Integer> list = naivePatternSearch("AABA","AABAACAADAABAABA");
		for(int i:list)
			System.out.println(i);
	}
	
	
	public static ArrayList naivePatternSearch(String pattern, String text){
		char[] pat = pattern.toCharArray();
		char[] txt = text.toCharArray();
		
		int m = pat.length;
		int n = txt.length;
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i=0;i<=n-m;i++){
			int j=0;
			for(j=0;j<m;j++)
				if(txt[i+j]!=pat[j])
					break;
			if(j==m) result.add(i); 
		}
		return result;
	}
	
	
	
}