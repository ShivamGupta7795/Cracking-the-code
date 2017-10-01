package leetcode;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

/*Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability
of being returned.*/
public class RandomizedSet {
	  /** Initialize your data structure here. */
    HashMap<Integer,Integer> map;
    ArrayList<Integer> list;
    Random random = new Random();
    public RandomizedSet() {
        map = new HashMap<Integer,Integer>();
        list= new ArrayList<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val)){
            list.add(val);
            map.put(val,list.size()-1);
            return true;
        }
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
       if(map.containsKey(val)){
           if(map.get(val)!=list.size()-1){
               int loc = map.get(val);
               int lastone = list.get(list.size()-1);
               list.set(loc,lastone);
               map.put(lastone,loc);
           }
           map.remove(val);
           list.remove(list.size()-1);
           return true;
       }
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
       return list.get(random.nextInt(list.size()));
    }
}
