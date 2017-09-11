
public class QuickSort {
	public static void main(String[] ar){
		int[] array = {5,4,3,2,1};
		array = new QuickSort().quicksort(array);
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
	}
	
	public int[] quicksort(int[] array){
		quicksort(array, 0, array.length-1);
		return array;
	}
	private void quicksort(int[] array, int left,int right){
		if(left>=right){
			return;
		}
		int pivot = (left+right)/2;
		int index = partition(array,left,right,pivot);
		quicksort(array,left,index-1);
		quicksort(array,index, right);
	}
	
	private int partition(int[] array, int left, int right, int pivot){
		while(left<=right){
			while(array[left]<array[pivot]){
				left++;
			}
			while(array[right]>array[pivot]){
				right--;
			}
			if(left<=right){
				swap(left, right, array);
				left++;
				right--;
				
			}
		}
		return left;
	}
	
	private void swap(int index1, int index2, int[] array){
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
}
