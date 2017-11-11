package leetcode;
import trees.Btree;
/*Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.*/
public class maxBinaryTree {
	 public Btree constructMaximumBinaryTree(int[] nums) {
	       
	        if(nums.length<1)
	            return null;
	      
	        Btree node = constructTree(nums, 0, nums.length-1);
	        return node;
	        
	    }
	    
	    Btree constructTree(int[] nums, int start, int end){
	        if(start>end)
	            return null;
	        

	        int index = start;
	        for(int i=start+1;i<=end;i++){
	            if(nums[index]<nums[i]){
	                index = i;
	            }   
	        }
	        Btree node = new Btree(nums[index]);
	        node.left = constructTree(nums, start, index-1);
	        node.right = constructTree(nums, index+1, end);
	        return node;
	    }
}
