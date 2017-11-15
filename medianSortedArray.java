package leetcode;
/*https://www.youtube.com/watch?v=LPFhl65R7ww&t=1204s*/
public class medianSortedArray {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if(nums1.length>nums2.length){
	        return findMedianSortedArrays(nums2, nums1);
	     }
	     
	     int len1 = nums1.length;
	     int len2 = nums2.length;
	      
	     int low = 0;
	     int high = len1;
	     
	     while(low<=high){
	         int partitionX = (low+high)/2;
	         int partitionY = ((len1+len2+1)/2) - partitionX;
	         
	         int maxLeftX = partitionX==0?Integer.MIN_VALUE:nums1[partitionX-1];
	         int minRightX  = partitionX==len1?Integer.MAX_VALUE:nums1[partitionX];
	         
	         int maxLeftY = partitionY==0?Integer.MIN_VALUE:nums2[partitionY-1];
	         int minRightY = partitionY==len2?Integer.MAX_VALUE:nums2[partitionY];
	         
	         if((maxLeftX<=minRightY) && (maxLeftY<=minRightX)){
	             if((len1+len2)%2==0){
	                 return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
	             }else{
	                 return (double)Math.max(maxLeftX, maxLeftY);
	             }
	         }else{
	             if(maxLeftY>minRightX){
	                 low = partitionX + 1;
	             }else{
	                 high = partitionX - 1;
	             }
	         }
	     }
	     return -1;
	 }  
}
