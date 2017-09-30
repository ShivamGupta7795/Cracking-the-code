package leetcode;
import java.util.*;
public class ShuffleArray {
	int[] array;
    Random random;
    public ShuffleArray(int[] nums) {
        array = nums;
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return array;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] shufflearray = Arrays.copyOf(array,array.length);
        for(int i=0;i<shufflearray.length;i++){
            int rand = random.nextInt(i+1);
            swap(shufflearray, rand, i);
        }
        return shufflearray;
    }
    
    public void swap(int[] shufflearray, int i, int j){
        int temp = shufflearray[i];
        shufflearray[i] = shufflearray[j];
        shufflearray[j] = temp;
    }
}
