package leetcode;
/*Find the first index in an array where a[i] = i, given that the array is sorted and has duplicates
 * Approach: Use binary search, but with slight modification. 
 * Since the values are in increasing order, we may have duplicates on either left or right side. 
 * While traversing left, instead of setting the end to mid-1, select min of index and value. Whereas, while 
 * traversing the right side, instead of setting start as mid+1, select max of index and value.
 * */
public class magicIndex {
	public int findMagicIndex(int[] array){
		return findMagicIndex(array, 0, array.length-1);
	}
	
	private int findMagicIndex(int[] array, int start, int end){
		if(start>end || start<0 || end>array.length-1){
			return -1;
		}
		int midIndex = (start+end)/2;
		int midVal = array[midIndex];
		
		if(midVal==midIndex)
			return midIndex;
		
		int leftIndex = Math.min(midVal, midIndex-1);
		int rightIndex = Math.max(midVal, midIndex+1);
		
		int left = findMagicIndex(array, start, leftIndex);
		if(left>0) return left;
		
		int right = findMagicIndex(array, rightIndex, end);
		return right;
		
	}
		
}
