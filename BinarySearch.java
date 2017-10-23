
public class BinarySearch {
	public static void main(String[] ar){
		
	}
	public static boolean binarysearch(int[] array, int key){
		return binarysearch(array, key, 0, array.length-1);
	}
	public static boolean binarysearch(int[] array, int key, int left, int right){
		if(left>right){
			return false;
		}
		int mid = (left+right)/2;
		if(array[mid]==key){
			return true;
		}
		if(array[mid]<key){
			return binarysearch(array, key, mid+1, right);
		}else{
			return binarysearch(array, key, left, mid-1);
		}
	}
}
