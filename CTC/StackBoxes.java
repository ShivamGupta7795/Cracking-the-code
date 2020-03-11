package CTC;

import java.util.Arrays;

/*given a list of boxes, arrange them in such a manner that each box should be greater than 
the box above it in terms of height, width and depth
Arrange boxes in such a manner that you can get max height.
*/
public class StackBoxes {
	
	
	public int getMaxHeight(Box[] boxes) {
		int maxHeight = 0;
		int height = 0;
		
		String s = "abcd";
		
		Arrays.sort(boxes, (a,b)->(b.height  - a.height));
		
		int[] memo = new int[boxes.length];
		
		for(int i=0;i<boxes.length;i++) {
			height = maxHeightHelper(boxes, i, memo);
			maxHeight = Math.max(maxHeight, height);
		}
		
		return maxHeight;
	}
	
	public int maxHeightHelper(Box[] boxes, int lastIndex, int[] memo) {
		
		if(lastIndex<boxes.length && memo[lastIndex] != 0) {
			return memo[lastIndex];
		}
		
		int maxHeight = 0;
		int height  =0;
		for(int i=lastIndex+1; i< boxes.length;i++) {
			if(canPlace(boxes, i, lastIndex)) {
				height = maxHeightHelper(boxes, i, memo);
				maxHeight= Math.max(height, maxHeight);
			}
		}
		memo[lastIndex] = maxHeight+boxes[lastIndex].height;
		return memo[lastIndex];
	}
	
	public boolean canPlace(Box[] boxes, int curBox, int lastBox) {
		return (boxes[curBox].height<boxes[lastBox].height) 
				&& (boxes[curBox].depth < boxes[lastBox].depth)
				&& (boxes[curBox].width < boxes[lastBox].width);
	}
}

class Box{
	int height;
	int width;
	int depth;
	
}