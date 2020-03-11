package CTC;

import java.util.Scanner;
import java.util.*;
public class vollyballRotation {
	public static void main(String[] args)
    {

       Scanner stdin = new Scanner(System.in);
       String[] num = new String[2];
      
       num[0] = "B95";
       num[1] = "101101";
       
        char[] numchar1 = num[0].toCharArray();
        char[] numchar2 = num[1].toCharArray();
       
        int base1 = findBase(numchar1);
        int base2 = findBase(numchar2);
        System.out.println("bases: "+base1+" "+base2);
        for(char c:numchar1){
        	System.out.println("numchar1: "+c);
        }
        
        for(char c:numchar2){
        	System.out.println("numchar2: "+c);
        }
        
        int nums1 = getnums(numchar1, base1);
//        int nums2 = getnums(numchar2, base2);
        int nums2= 0;
        System.out.println("nums: "+nums1+ " "+ nums2);
        int result = nums1+nums2;
       System.out.println(result);
       
       
       
       
       
       
       stdin.close();
    }
    
    public static int findBase(char[] nums){
        int max = 0;
       for(int i=0;i<nums.length;i++){
           max= Math.max(max, nums[i]);
       }
       return max<58?(max-47): (max-'A'+11);
    }
    
    public static int getnums(char[] nums, int base){
        int result = 0;
        for(int i=0;i<nums.length;i++){
        	if(nums[i]<58)
        		result = (int)((nums[i]-48) * Math.pow(base, nums.length-i-1));
        	else
        		result = (int)((nums[i]-'A'+10) * Math.pow(base, nums.length-i-1));
        	System.out.println("result:"+ result);
        }
        return result;
    }
}
