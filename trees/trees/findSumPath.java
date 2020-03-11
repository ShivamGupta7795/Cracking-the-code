package trees;

public class findSumPath {
	public static void main(String[] ar){
		
	}
	public static void findSum(Btree root, int sum, int[] array, int level){
		if(root==null){
			return;
		}
		array[level]= root.data;
		int temp= 0;
		for(int i=level-1;i>=0;i--){
			temp += array[i];
			if(sum==temp){
				print(array,i,level);
			}
		}
		
		findSum(root.left,sum,array,level+1);
		findSum(root.right,sum,array,level+1);
		return;
	}
	public static void print(int[] array,int start, int end){
		for(int i=start;i<end;i++){
			System.out.println(array[i]);
		}
	}
	
	public void findSum(Btree root, int sum){
		int depth = depth(root);
		int[] array = new int[depth];
		findSum(root,sum,array,depth);
	}
	
	public int depth(Btree root){
		if(root==null){
			return 0;
		}
		return Math.max(depth(root.left), depth(root.right))+1;
	}
	
}
