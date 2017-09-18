
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
	public static boolean checkbalanceBT(Btree root){
		if(checkHeight(root)==-1){
			return false;
		}else{
			return true;
		}
	}
}
