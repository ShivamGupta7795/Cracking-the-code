
public class Check_Balanced_BST {
	public static void main(String[] str){
		
	}
	public static int checkHeight(Btree node){
		int left = checkHeight(node.left);
		if(left==-1){
			return -1;
		}
		int right = checkHeight(node.right);
		if(right==-1){
			return -1;
		}
		int height = left-right;
		if(height>1){
			return -1;
		}else{
			return Math.max(left, right)+1;
		}
	}
	
	public static boolean isBalanced(Btree root){
		 if(root==null)
            		return true;
        	int left = checkHeight(root.left);
        	int right = checkHeight(root.right);
        	return Math.abs(left-right)<=1  && isBalanced(root.left) && isBalanced(root.right);
	}
}
