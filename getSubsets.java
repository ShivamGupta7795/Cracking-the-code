package leetcode;
import java.util.ArrayList;
/*Get all the subsets of a set. 
 * Solution: 
 * with every iteration, copy the previous sets and add the new item to the already existing subsets. Eg.
 * intially we have subsets {}, {1} 
 * next iteration we'll add new item 2; therefore new sets are: {},{1},{2},{1,2}
 * for new item 3: {}, {1}, {2}, {1,2}, {3}, {1,3}, {2,3}, {1,2,3}
 * time complexity: O(2^n)*/
public class getSubsets {
	
	public ArrayList<ArrayList<Integer>> findSubsets(ArrayList<Integer> set){
		return findSubsets(set, set.size()-1);
	}
	
	
	private ArrayList<ArrayList<Integer>> findSubsets(ArrayList<Integer> set, int index){
		ArrayList<ArrayList<Integer>> allSubsets;
		if(index==-1){
			allSubsets = new ArrayList<ArrayList<Integer>>();
			allSubsets.add(new ArrayList<Integer>()); //add an empty set
		}else{
			allSubsets = findSubsets(set, index-1); //make a recursive call for each element in the set.
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> tempSets = new ArrayList<ArrayList<Integer>>(); //create a temp set, which will
			//contains the new generated subsets.
			
			for(ArrayList<Integer> subset: allSubsets){
				ArrayList<Integer> newset=  new ArrayList<Integer>();
				newset.addAll(subset);
				newset.add(item);
				tempSets.add(newset);
			}
			allSubsets.addAll(tempSets); //add the newly generated subsets to allSubset.
		}
		return allSubsets;
		
	}
	
}
