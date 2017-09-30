package leetcode;
import java.util.HashMap;
/*Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that 
 * A[i] + B[j] + C[k] + D[l] is zero.
To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the 
range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
 * */
public class FourSumII {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> list = new HashMap<Integer, Integer>();
        int result = 0;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                int sum = -1*(A[i]+B[j]);
                // if(list.containsKey(sum)){
                //     int count = list.get(sum);
                //     list.put(sum, ++count);
                // }else{
                //     list.put(sum,1);
                // }
                /*Alternative to above if else method 
                Excellent method defined in java. Reduced the running time by half as compared to 
                if else statement.*/
                list.put(sum, list.getOrDefault(sum,0)+1);
            }
        }
        
        for(int i=0;i<C.length;i++){
            for(int j=0;j<D.length;j++){
                // if(list.containsKey(C[i] + D[j])){
                //     result+= list.get(C[i] + D[j]);
                // }
                result += list.getOrDefault(C[i] + D[j], 0);
            }
        }
        return result;
    }
}
