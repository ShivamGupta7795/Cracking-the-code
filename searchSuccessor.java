
package Btree;
public class searchSuccessor {
	public static void main(String[] ar){
		
	}
	public static Btree searchpred(Btree node, Btree root){
		if(root==null ||node==null){
			return null;
		}
		Btree lastnode = null;
		return searchpred(node,root,lastnode);
	}
	private static Btree searchpred(Btree node, Btree root, Btree lastvalue){
		if(root==null){
			return null;
		}
		searchpred(node,root.left,lastvalue);
		if(root.data==node.data){
			return lastvalue;
		}
		lastvalue  = root;
		searchpred(node,root,lastvalue);
		return lastvalue;
	}
	
	public static Btree searchSucc(Btree node, Btree root){
		if(root.right!=null){
			return getLeftMost(node);
		}else{
			Btree parent = node.parent;
			while(parent!=null&&parent.left!=node){
				node = parent;
				parent = parent.parent;
			}
			return parent;
		}
	}
	private static Btree getLeftMost(Btree node){
		if(node.left == null){
			return node;
		}
		return getLeftMost(node.left);
	}
	
}
