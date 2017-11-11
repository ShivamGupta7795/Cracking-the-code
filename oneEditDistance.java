package leetcode;

public class oneEditDistance {
	public boolean isOneEdit(String s1, String s2){
		int m = s1.length();
		int n = s2.length();
		
		if(Math.abs(m-n)>1){
			return false;
		}
		int i=0, j=0, count = 0;
		while(i<m && j<n){
			if(s1.charAt(i)!=s2.charAt(j)){
				if(++count>1)
					return false;
				if(m>n)
					i++;
				else if(n<m)
					j++;
				else{
					i++; j++;
				}		
			}else{
				i++;
				j++;
			}
		}
		return (i<m||j<n)?++count==1:false;
	}
	/*elegant solution*/
	public boolean minDistance2(String s1, String s2){
		int m = s1.length();
		int n = s2.length();
		
		if(Math.abs(m-n)>1){
			return false;
		}
		
		int i=0;
		int len = Math.min(m, n);
		while(i<len){
			if(s1.charAt(i)!=s2.charAt(i)){
				if(m==n)
					return s1.substring(i+1).equals(s2.substring(i+1));
				if(m<n)
					return s1.substring(i).equals(s2.substring(i+1));
				else
					return s1.substring(i+1).equals(s2.substring(i));
			}
			i++;
		}
		return false; //since all the chars are same, there is no difference.
	}
}
