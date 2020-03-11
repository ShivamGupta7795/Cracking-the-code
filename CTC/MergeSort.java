package CTC;
public class MergeSort {
	public static void main(String[] ar){
		int[] arr = {9,7,8,4,6};
		mergesort(arr);
		for(int i:arr)
			System.out.println(i);
		
	}
	/*Mergesort approach:
	 * Divide the array repetitively and sort each half after dividing the array. After all the halves are sorted
	 * start merging the halves and in a sorted manner. */
	public static void mergesort(int[] array){
		mergesort(array, new int[array.length-1], 0, array.length-1);
	}
	private static void mergesort(int[] array, int[] temp, int left, int right){
		if(left>=right){
			return;
		}
		int pivot = (left+right)/2;
		/*Divide and sort part*/
		mergesort(array,temp,left, pivot);
		mergesort(array,temp,pivot+1, right);
		/*Merge the sorted halves*/
		merge(array,temp,left,right);
	}
	
	private static void merge(int[] array, int[] temp, int leftStart, int rightEnd){
		if(leftStart<=rightEnd){
			return;
		}
		
		int leftEnd = (leftStart+rightEnd)/2;
		int rightStart = leftEnd+1;
		int size = rightEnd-leftStart+1;
		
		int left = leftStart;
		int right = rightStart;
		int index = leftStart;
		
		while(left<=leftEnd && right<=rightEnd){
			if(array[left]<=array[right]){
				temp[index] = array[left];
				left++;
			}else{
				temp[index] = array[right];
				right++;
			}
			index++;	
		}
		/*Either of the halves will have extra elements which needs to be copied to temp and then copy all the
		 * elements in array to temp*/
		System.arraycopy(array, left, temp, index, left-leftStart+1);
		System.arraycopy(array, right, temp, index,	right-rightStart+1);
		System.arraycopy(array, leftStart, temp, leftStart, size);
	
		array = temp;
		
		
	}
}
