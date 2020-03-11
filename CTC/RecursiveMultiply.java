package CTC;
// find multiplication of two numbers without using the * or /
public class RecursiveMultiply {

	public static void main(String[] ar) {
		
	}
	
	
	// consider a*b as matrix, to count all the blocks, divide matrix in half and then double it. Repeat process of halving the matrix
	// until it reaches 0 or 1. If matrix size is not even then do counting from scratch.
	public int getProduct(int smaller, int bigger, int[] memo) {
		
		if(smaller == 0) {
			return 0;
		} 
		
		if(smaller == 1) {
			return bigger;
		}
		
		if(memo[smaller] != 0) {
			return memo[smaller];
		}
		
		int half = smaller>>1; // divide by 2
		
		int side1 = getProduct(smaller, bigger, memo);
		int side2 = side1;
		
		if(smaller%2 == 1) {
			side2 = getProduct(smaller-half, bigger, memo);
		}
		
		memo[smaller] = side1+side2;
		
		return memo[smaller];
	}
	
	// previously to compute multiplication with an odd number we were repeating our recursive calls. Although, using memo made it efficient
	// but still here we don't need that. for eg. 30x35 can will make one call for (15, 35) and then doubles it but for (31, 35) we make two calls
	// (15, 35) and (16,35) which is unnecessary. since 31x35 can be represented as 2*getProduct(15, 35) + 35 i.e. half*2 + bigger.
	// more explanation on page 273
	
	public int betterGetProduct(int smaller, int bigger) {
		if(smaller == 0) return 0;
		if(smaller == 1) return bigger;
		
		int half = betterGetProduct(smaller>>1, bigger);
		
		if(half%2 ==0) {
			return half+half;
		} else {
			return half+half+bigger;
		}
	}
}
