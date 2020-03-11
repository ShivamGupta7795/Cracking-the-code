package CTC;


public class Bubble_Sort {
	public static void main(String[] ar){
		int[] array = {5,4,3,2,1};
		array = new Bubble_Sort().bubblesort(array);
	}
	/*Method 1*/
	public int[] bubblesort(int[] array){
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array.length-1;j++){
				if(array[j]>array[j+1]){
					swap(j,j+1, array);
				}
			}
		}
		return array;
	}
	
	/*Method 2: Slightly more efficient due to reduced array length after each iteration*/	
	public int[] bubblesort2(int[] array){
		boolean sorted = false;
		int arraylength = array.length-1;
		while(!sorted){
			sorted = true;
			for(int i=0;i<arraylength;i++){
				if(array[i]>array[i+1]){
					swap(i,i+1,array);
					sorted = false;
				}
			}
			arraylength--;
		}
		return array;
	}
	
	public void swap(int a, int b, int[] ar){
		int temp = ar[a];
		ar[a]= ar[b];
		ar[b]=temp;;
		return;
	}
}
