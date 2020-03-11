package CTC;

import java.util.Scanner;

public class expectoPalindrome {
	public static void main(String[] args)
    {

       Scanner stdin = new Scanner(System.in);
       String str= new String();
      str= "aaaba";
       int count = str.length();
       
       while(!isPalindrome(str)){
           char[] ch = str.toCharArray();
           StringBuilder sb = new StringBuilder();
            int i=0, j= ch.length-1;
            while(i<j){
               if(ch[i]!=ch[j]) {
                  
                   sb.append(ch[j]);
                   count++;
                   j--;
               }
               else{
                   i++;
                   j--;
               }
            }
//            sb.append(str);
            str = sb.append(str).toString();
       }
       
       
      System.out.println(count+" "+str);
       stdin.close();
    }
    
    public static boolean isPalindrome(String str){
        for(int i=0,j=str.length()-1;i<j;i++,j--){
            if(str.charAt(i)!=str.charAt(j)) return false;
        }
        return true;
    }
    
}
