
public class Btree {
	Btree left, right;
	int data;
	public Btree(int data){
		this.data = data;
	}
}

class Btree_create{
	Btree root;
	
	public void insert(int data){
		insert(root, data);
	}
	
	private void insert(Btree node, int data){
		if(node==null){
			node = new Btree(data);
			return;
		}else{
			if(data>node.data){
				insert(node.right, data);
			}else{
				insert(node.left, data);
			}
		}
		return;
	}
	
	int countNodes(Btree root){
		if(root==null){
			return 0;
		}else{
			int count =  1;
			count += countNodes(root.left);
			count += countNodes(root.right);
			return count;
		}
	}
	
	public boolean search(int data){
		return search(root, data);
	}
	
	private boolean search(Btree node, int data){
		if(node==null){
			return false;
		}
		if(node.data == data){
			return true;
		}
		if(node.data>data){
			search(node.left, data);
		}else{
			search(node.right, data);
		}	
		return false;
	}
	
	public void inorder(Btree node){
		if(node!=null){
			inorder(node.left);
			System.out.println(node.data);
			inorder(node.right);
		}
		return;
	}
	
	public void preorder(Btree node){
		if(node!=null){
			System.out.println(node.data);
			preorder(node.left);
			preorder(node.right);
		}
	}
	
	public void postorder(Btree node){
		if(node!=null){
			postorder(node.left);
			postorder(node.right);
			System.out.println(node.data);
		}	
	}
	
}
