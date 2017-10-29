package leetcode;
import java.util.Scanner;
public class generatePalindrome {
	public static void main(String[] args)
    {
       Scanner stdin = new Scanner(System.in);
       String input = new String();
       input = stdin.nextLine();
       
        if(input.length()<2)
            System.out.println(input.length());
        else{
            String reverse = new StringBuilder(input).reverse().toString();
            int[] lps = computeLPS(input+"$"+reverse);
            int char_needed = input.length() - lps[lps.length-1];
            System.out.println(char_needed);
        }
       
       
       stdin.close();
    }
    
    public static int[] computeLPS(String str){
        int[] lps= new int[str.length()];
        int len = 0;
        lps[0] = 0;
        int i=1;
        while(i<str.length()){
            if(str.charAt(i) == str.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len!=0){
                    len = lps[len-1];
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
        
    }
}
