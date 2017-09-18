package trees;
public class BSTFromSortedArray {
	public static void main(String ar[]){
		
	}
	public static Btree creatBST(int[] array){
		return createBST(array,0,array.length-1);
	}
	/*Combination of BST and Binary Search: Kid's stuff*/
	private static Btree createBST(int[] array, int left, int right){
		if(left>right){
			return null;
		}
		int mid = (int)Math.ceil(left+right/2);
		Btree root = new Btree(array[mid]);
		root.left = createBST(array,left,mid-1);
		root.right = createBST(array,mid+1, right);
		return root;
	}
}
