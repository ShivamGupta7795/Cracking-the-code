package leetcode;
/*LINK: https://www.hackerearth.com/practice/algorithms/dynamic-programming/2-dimensional/tutorial/
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. 
 * (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
 * 
 
 Video Explanation:
 https://www.youtube.com/watch?v=We3YDTzNXEk&index=8&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr
 
 https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/EditDistance.java
 * */
public class editDistance {
	public int minDistance(String s1, String s2) {
     int m = s1.length();
	 int n = s2.length();
	// for all i, j, dp[i][j] will hold the edit distance between the first  
     // i characters of source string and first j characters of target string  
	 int[][] dp = new int[m+1][n+1];
	 
	// source prefixes can be transformed into empty string by  
     // by deleting all of the characters  
    for(int i=1;i<=m;i++){
		 dp[i][0] = i;
	 }
    
    // source can be transformed into target prefix by inserting  
    // all of the characters in the prefix  
	 for(int i=1;i<=n;i++){
		 dp[0][i] = i;
	 }
	 
	 for(int i=1;i<=m;i++){
		 for(int j=1;j<=n;j++){
             if(s1.charAt(i-1)==s2.charAt(j-1)){
                 dp[i][j] = dp[i-1][j-1]; // no operation required as characters are the same.  
             }else{
                 dp[i][j] = 1+Math.min(dp[i-1][j-1], // substitution  
                		 Math.min(dp[i-1][j], //deletion
                				 dp[i][j-1])); //insertion
             }
         }
	 }
        return dp[m][n];
    }
}
