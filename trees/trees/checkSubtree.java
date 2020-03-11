package trees;
public class checkSubtree {
	public static void main(String[] ar){
		
	}
	/*T1 is a million node tree. We have to find whether there exist a subtree in T1 which matches 
	 * the structure of T2. Size of T2 is some hundreds of nodes.*/
	public static boolean checksubtree(Btree T1, Btree T2){
		if(T1==null){
			return false;
		}
		
		if(matchsubtree(T1,T2)){
			return true;
		}
		return checksubtree(T1.left,T2) || checksubtree(T1.right,T2);
	}
	
	private static boolean matchsubtree(Btree T1, Btree T2){
		if(T1==null || T2 == null){
			return T1==T2;
		}
		
		if(T1.data!=T2.data){
			return false;
		}
		return matchsubtree(T1.left, T2.left) && matchsubtree(T1.right, T2.right);
	}
}
