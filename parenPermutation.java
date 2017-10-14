package leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
public class parenPermutation {
	public static void main(String[] ar){
		ArrayList<String> paren = new parenPermutation().findPermutation(4);
		int count = 0;
		for(int i=0;i<paren.size();i++){
			System.out.println(++count+": "+paren.get(i));
		}
		
	}
	public ArrayList<String> findPermutation(int n){
		ArrayList<String> paren = new ArrayList<String>();
		if(n==1){
			paren.add("()");
		}else{
			paren = findPermutation(n-1);
			String open = "(";
			String close= ")";
			HashSet<String> temp = new HashSet<String>();
			for(String s: paren){
				temp.add(open + s + close);
				temp.add(open + close +s);
				temp.add(s + open + close);
			}
			ArrayList<String> result = new ArrayList<String>(temp);
			return result;
		}
		return paren;
	}
	
}
