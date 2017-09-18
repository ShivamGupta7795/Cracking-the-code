package trees;
public class Bsearch {
	public static void main(String str[]){
		int[] ar= {1,2,3,4,5,6,7,8,9};
		System.out.println(search(2,ar,0,8));
	}
	
	public static boolean search(int i, int ar[], int low, int high){
		if(low==high)
			return false;
		else
		{
		int mid = (low+high)/2;
		if(i==ar[mid]){
			return true;
		}else{
			if(i>ar[mid]){
				search(i, ar, mid+1, high);
			}else{
				search(i, ar, low, mid-1);
			}
		}
		}
		return false;
	}
}
