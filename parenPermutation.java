package leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
public class parenPermutation {
	public static void main(String[] ar){
		ArrayList<String> paren = new parenPermutation().findPermutation(4);
		int count = 0;
		for(int i=0;i<paren.size();i++){
			System.out.println(++count+":paren: "+paren.get(i));
		}
		
		ArrayList<String> perm= new parenPermutation().generatePerm(4);
		count = 0;
		for(int i=0;i<perm.size();i++){
			System.out.println(++count+": "+perm.get(i));
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
	
	private void findPermutation(ArrayList<String> list, int leftrem, int rightrem, char[] str, int count){
		if(leftrem<0 || rightrem<leftrem) return;
		
		if(leftrem==0 && rightrem==0){
			String s = String.copyValueOf(str);
			list.add(s);
		}else{
			if(leftrem>0){
				str[count] = '(';
				findPermutation(list, leftrem-1, rightrem, str, count+1);
			}
			if(rightrem>leftrem){
				str[count] = ')';
				findPermutation(list, leftrem, rightrem-1, str, count+1);
			}
		}
	}
	
	public ArrayList<String> generatePerm(int count){
		char[] str= new char[count*2];
		ArrayList<String> list= new ArrayList<String>();
		findPermutation(list, count, count, str, 0);
		return list;
	}
	
}
