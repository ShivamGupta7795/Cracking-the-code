package leetcode;

public class minGates {
	public static void main(String[] ar){
		System.out.println(new minGates().minFlightGates(new int[] {900,940,950,1100,1500,1800}, new int[]{910,1120,1130,1200,1900,2000}, 6));
	}
	
	public int minFlightGates(int[] arrival, int[] depart, int flights){
		int count = 0, max = 0, arr= 0, dep=0;
		for(int i=0;i<flights;i++){
			if(arrival[arr]<=depart[dep]){
				count++;
				arr++;
			}else{
				count--;
				dep++;
			}
			max = Math.max(count, max);
		}
		return max;
	}
}
