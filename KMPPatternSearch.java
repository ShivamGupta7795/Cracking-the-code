package leetcode;
import java.util.ArrayList;
public class KMPPatternSearch {
	public static void main(String[] ar){
		ArrayList<Integer> list= patternMatch("ABABDABACDABABCABAB", "ABABCABAB");
		for(int i:list){
			System.out.println(i);
		}
	}
	public static ArrayList patternMatch(String str, String pattern){
		char[] pat = pattern.toCharArray();
		char[] s = str.toCharArray();
		int patlen = pat.length;
		int slen = s.length;
		int i=0,j=0;
		int[] lps = new int[patlen];
		preprocesslps(lps, pattern);
		ArrayList result = new ArrayList<Integer>();
		while(i<slen){
			if(s[i]==pat[j]){
				i++;
				lps[j] = j;
				j++;
			}else{
				if(j!=0)
					j = lps[j-1];
				else
					i++;
			}
			
			if(j==patlen){
				result.add(i-j);
				j = lps[j-1];
			}
		}
			
		return result;
	}
	
	public static void preprocesslps(int[] lps, String pat){
		 int len = 0;
		 int M = pat.length();
	        int i = 1;
	        lps[0] = 0;  // lps[0] is always 0
	 
	        // the loop calculates lps[i] for i = 1 to M-1
	        while (i < M)
	        {
	            if (pat.charAt(i) == pat.charAt(len))
	            {
	                len++;
	                lps[i] = len;
	                i++;
	            }
	            else  // (pat[i] != pat[len])
	            {
	                // This is tricky. Consider the example.
	                // AAACAAAA and i = 7. The idea is similar 
	                // to search step.
	                if (len != 0)
	                {
	                    len = lps[len-1];
	 
	                    // Also, note that we do not increment
	                    // i here
	                }
	                else  // if (len == 0)
	                {
	                    lps[i] = len;
	                    i++;
	                }
	            }
	        }
	}
}	
