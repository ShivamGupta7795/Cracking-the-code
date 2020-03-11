package trees;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BinarySearch {
	public static void main(String[] ar){
		System.out.println(binarysearch(new int[]{1,2,3,4,5},21));
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
		if(array[mid]>key){
			return binarysearch(array, key, left, mid-1);
		}else{
			return binarysearch(array, key, mid+1, right);
		}
	}
}
