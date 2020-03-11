package CTC;




import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class googleTest{

	class buildingList implements Comparable<buildingList>{
        int x;
        int h;
        boolean isStart;
     

		@Override
		public int compareTo(buildingList o) {
			if(this.x!=o.x)
				return this.x-o.x;
			else
				return ((this.isStart)?(-this.x):(this.x)) - ((o.isStart)?(-o.x):o.x);
		}
        
    }
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String s = "fffh";
		System.out.println(s.lastIndexOf("\t"));
		
		 Comparator<int[]> cmp = new Comparator<int[]>(){
	          public int compare(int[] a, int[] b){
	              return a[0]!=b[0]?b[0]-a[0]:a[1]-b[1];
	          }
	     };
	     
	     PriorityQueue<Integer> q= new PriorityQueue<Integer>(new Comparator<Integer>(){
				public int compare(Integer a, Integer b){
					return b-a;
				}
	     });
	     
	        
	     PriorityQueue<Integer> queue= new PriorityQueue<Integer>((a,b)->b-a);
	     
	     
	     class ListNode {
	    	    int val;
	    	      ListNode next;
	    	      ListNode(int x) { val = x; }
	     }
	     
	 
    }
}
	
