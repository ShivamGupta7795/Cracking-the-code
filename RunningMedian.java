import java.util.PriorityQueue;
import java.util.Comparator;
public class RunningMedian {
	public static void main(String ar[]){
		
	}
	/*Problem:
	 * Find median of the array while traversing the array.
	 * Solution:
	 * 1. Sort the array each time while moving forward to next element. Complexity= n^2
	 * 2. Create two buckets of array, one with lower half and other with higher half.
	 * If both bucket size are equal then take the min element from higher half and max element
	 * from lower half and average the two numbers.
	 * Else take the min element from the higher half bucket
	 * Approach: Add elements to the buckets while moving forward in array. Rebalance the buckets
	 * after each addition to make sure that the difference b/w the size of the two buckets should not
	 * be greater than 1. After rebalancing the buckets, find the median of the two buckets.*/
	public void getMedian(int[] array){
		Comparator<Integer> reverse = new Comparator<Integer>(){
			public int compare(Integer a, Integer b){
				return -1*a.compareTo(b);
			}
		};
		PriorityQueue<Integer> lowers = new PriorityQueue<Integer>(reverse);
		PriorityQueue<Integer> highers = new PriorityQueue<Integer>();
		double[] median = new double[array.length];
		for(int num=0;num<array.length;num++){
			addToBucket(array[num], lowers, highers);
			resetHeap(lowers, highers);
			median[num] = getMedian(lowers, highers);
		}	
	}
	
	public void addToBucket(int num, PriorityQueue<Integer> lowers,PriorityQueue<Integer> highers){
		if(lowers.size()==0||num<lowers.peek()){
			lowers.add(num);
		}else{
			highers.add(num);
		}
	}
	
	public void resetHeap(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
		PriorityQueue<Integer> minHeap = lowers.size()<highers.size()?lowers:highers;
		PriorityQueue<Integer> maxHeap = lowers.size()>highers.size()?lowers:highers;		
		while(maxHeap.size()-minHeap.size()>1){
			minHeap.add(maxHeap.poll());
		}
	}
	
	public double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
		PriorityQueue<Integer> minHeap = lowers.size()<highers.size()?lowers:highers;
		PriorityQueue<Integer> maxHeap = lowers.size()>highers.size()?lowers:highers;	
		
		if(maxHeap.size()==minHeap.size()){
			return ((double)maxHeap.peek()+minHeap.peek())/2;
		}else{
			return maxHeap.peek();
		}	
	}
	
	
	
}
