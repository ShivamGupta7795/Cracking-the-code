package CTC;
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
		
		int patlen = pat.length;
		int txtlen = txt.length;
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i=0;i<=txtlen-patlen;i++){
			int j=0;
			for(j=0;j<patlen;j++)
				if(txt[i+j]!=pat[j])
					break;
			if(j==patlen) result.add(i); 
		}
		return result;
	}
	
	
	
}
