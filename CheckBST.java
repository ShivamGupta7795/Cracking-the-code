
public class CheckBST {
	public	static void main(String[] ar){
		
	}
	/*checks if a tree is a binary tree. Instead of comparing the max value of the left side of the root with minimum value
	 * of right side of root, we set the value of a min and a max for each node. If node lies outside that range than return false
	 * false otherwise if we hit the end of the tree then return true; */
	public static boolean checkBST(Btree root){
		return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	public static boolean checkBSTWithInorder(Btree root){
		return checkBSTInorder(root);
	}
	private static boolean checkBST(Btree root, int min, int max){
		if(root==null){
			return true;
		}
		if(root.data<min || root.data>max){
			return false;
		}
		return checkBST(root.left, min, root.data-1)&&checkBST(root.right, root.data+1, max);
	}
	/*Method 2: Use inorder traversal*/
	private static boolean checkBSTInorder(Btree root){
		int lastelement  = Integer.MIN_VALUE;
		if(root ==null){
			return true;
		}
		if(!checkBSTInorder(root.left)){
			return false;
		}
		if(root.data<lastelement){
			return false;
		}
		lastelement = root.data;
		
		if(!checkBSTInorder(root.right)){
			return false;
		}
		return true;
	}
	
	
}
