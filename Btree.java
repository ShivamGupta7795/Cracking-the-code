
public class Btree {
	Btree left, right;
	int data;
	public Btree(int data){
		this.data = data;
	}
}

class Btree_create{
	Btree root;
	
	Btree insert(Btree node, int data){
		if(node==null){
			node = new Btree(data);
		}else{
			if(node.right==null){
				node.right= insert(node.right, data);
			}else{
				node.left = insert(node.left, data);
			}
		}
		return node;
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
	
	
	public boolean search(Btree node, int data){
		if(node.data == data){
			return true;
		}
		if(node.left!=null){
			if(search(node.left, data)){
				return true;
				}
		}
		if(node.right!=null){
			if(search(node.right, data)){
				return true;
			}
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
