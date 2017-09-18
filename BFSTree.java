import java.util.LinkedList;
import java.util.ArrayList;
public class BFSTree {
	public static void main(String[] ar){
		
	}
	public static void BFS(Btree root){
		ArrayList<LinkedList<Btree>> levels = new ArrayList<LinkedList<Btree>>();
		LinkedList<Btree> list = new LinkedList<Btree>();
		list.add(root);
		while(!list.isEmpty()){
			levels.add(list);
			LinkedList<Btree> parents = list;
			list = new LinkedList<Btree>();
			for(Btree parent:parents){
				if(parent.left!=null){
					list.add(parent.left);
				}
				if(parent.right!=null){
					list.add(parent.right);
				}
			}
		}
	}
}
