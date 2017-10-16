package leetcode;
import java.util.ArrayList;
import java.util.Arrays;
public class KSubsetEqualSum {
	 public boolean canPartitionKSubsets(int[] nums, int k) {
	        if(k==1)
	            return true;
	        
	        if(k>nums.length)
	            return false;
	        
	        int sum =0;
	        for(int i:nums)
	            sum += i;
	        if(sum%k!=0)
	            return false;
	        
	        sum = sum/k;        
	        /*Create all the subsets of a set*/
	        ArrayList<Integer> numslist= new ArrayList(Arrays.asList(nums));
	        ArrayList<ArrayList<Integer>> list = findSubsets(numslist, nums.length-1);
	        int count = 0;
	        for(ArrayList<Integer> temp: list){
	            int tempsum = 0;
	            for(int i:temp){
	                tempsum += i;
	            }
	            if(tempsum==sum)
	                count++;
	        }
	        
	        if(count>=k)
	            return true;
	        return false;
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

