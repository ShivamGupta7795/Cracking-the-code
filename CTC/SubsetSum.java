package CTC;

import java.util.ArrayList;

/*
 *thumb rule of dp:
 *either you include the current element => dp[i-1][j-currentVal] or dp[i-currentVal]
 *or you exlude the current element => dp[i-1][j] or dp[i]
 *
 * Given an array of integers and a sum, the task is to print all subsets of given array with sum equal to given sum.

Examples:

Input : arr[] = {2, 3, 5, 6, 8, 10}
        sum = 10
Output : 5 2 3
         2 8
         10

Input : arr[] = {1, 2, 3, 4, 5}
        sum = 10
Output : 4 3 2 1 
         5 3 2 
         5 4 1 
         
         https://www.youtube.com/watch?v=s6FhG--P7z0
 * */

public class SubsetSum {
	static boolean[][] dp; 
    
    static void display(ArrayList<Integer> v) 
    { 
       System.out.println(v); 
    } 
       
    // A recursive function to print all subsets with the 
    // help of dp[][]. Vector p[] stores current subset. 
    static void printSubsetsRec(int arr[], int i, int sum,  
                                         ArrayList<Integer> p) 
    { 
        // If we reached end and sum is non-zero. We print 
        // p[] only if arr[0] is equal to sun OR dp[0][sum] 
        // is true. 
        if (i == 0 && sum != 0 && dp[0][sum]) 
        { 
            p.add(arr[i]); 
            display(p); 
            p.clear(); 
            return; 
        } 
       
        // If sum becomes 0 
        if (i == 0 && sum == 0) 
        { 
            display(p); 
            p.clear(); 
            return; 
        } 
       
        // If given sum can be achieved after ignoring 
        // current element. 
        if (dp[i-1][sum]) 
        { 
            // Create a new vector to store path 
            ArrayList<Integer> b = new ArrayList<>(); 
            b.addAll(p); 
            printSubsetsRec(arr, i-1, sum, b); 
        } 
       
        // If given sum can be achieved after considering 
        // current element. 
        if (sum >= arr[i] && dp[i-1][sum-arr[i]]) 
        { 
            p.add(arr[i]); 
            printSubsetsRec(arr, i-1, sum-arr[i], p); 
        } 
        
        /*
         * if we want to take same element more than once then
         * 
         * if(sum>= A[i] && dp[i][sum - A[i]]){
         *    p.add(A[i]);
         *    printSubset(arr, i, sum - A[i], p);
         * }
         * 
         * */
    } 
       
    // Prints all subsets of arr[0..n-1] with sum 0. 
    static void printAllSubsets(int arr[], int n, int sum) 
    { 
        if (n == 0 || sum < 0) 
           return; 
       
        // Sum 0 can always be achieved with 0 elements 
        dp = new boolean[n][sum + 1]; 
        for (int i=0; i<n; ++i) 
        { 
            dp[i][0] = true;   
        } 
       
        // Sum arr[0] can be achieved with single element 
        if (arr[0] <= sum) 
           dp[0][arr[0]] = true; 
       
        // Fill rest of the entries in dp[][] 
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < sum + 1; ++j) {
                dp[i][j] = (arr[i] <= j) ? (dp[i-1][j] || 
                                           dp[i-1][j-arr[i]]) 
                                         : dp[i - 1][j]; 
                /*
                 * if we want to consider same element more than once then
                 * 
                 * dp[i][j] = (arr[i] <= j) ? (dp[i-1][j] || 
                                           dp[i-1][j-arr[i]]) || dp[i][j-A[i]]
                                         : dp[i - 1][j]; 
                 * 
                 * */
             }
        }
        if (dp[n-1][sum] == false) 
        { 
            System.out.println("There are no subsets with" +  
                                                  " sum "+ sum); 
            return; 
        } 
       
        // Now recursively traverse dp[][] to find all 
        // paths from dp[n-1][sum] 
        ArrayList<Integer> p = new ArrayList<>(); 
        printSubsetsRec(arr, n-1, sum, p); 
    } 
      
    //Driver Program to test above functions 
    public static void main(String args[]) 
    { 
        int arr[] = {1, 2, 3, 4, 5}; 
        int n = arr.length; 
        int sum = 10; 
        printAllSubsets(arr, n, sum); 
    } 
    
    //find if with current elements we can compute given target
    public static boolean isSubsetSumExist(int[] nums, int target) {
    	boolean[] dp = new boolean[target];
    	dp[0] = true;
    	for(int num: nums) {
    		for(int i = dp.length-1; i>= num; i--) {
    			dp[i] = dp[i] || dp[i-num];
    		}
    	}
    	
    	return dp[dp.length -1];
    }

}
