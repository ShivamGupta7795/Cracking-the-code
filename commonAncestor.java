
public class commonAncestor {
	public static void main(String[] ar){
		
	}
	public static Btree checkCommonAncestor(Btree root, Btree node1, Btree node2){
		boolean isNode1Left = isChild(node1, root.left);
		boolean isNode2Left = isChild(node2, root.left);
		if(isNode1Left != isNode2Left){
			return root;
		}
		Btree node = isNode1Left?root.left:root.right;
		return checkCommonAncestor(node,node1,node2);
	}
	
	public static boolean isChild(Btree node,Btree root){
		if(root==null) 
			return false;
		if(node==root)
			return true;
		return isChild(node,root.left) || isChild(node, root.right);
	}
}
