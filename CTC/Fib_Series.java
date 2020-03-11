package CTC;
public class Fib_Series {
	public static void main(String ar[]){
//		System.out.println(new Fib_Series().Fibonacci_Series(5));
		String points = "abcd.google.com";
		String[] strarr = points.split("\\.");
		
		for(String str: strarr) {
			System.out.println(str);
		}
		
		
		
	}
	
	public int Fibonacci_Series(int num){
		if(num==0){
			return 0;
		}
		if(num==1){
			return 1;
		}
		int[] memo = new int[num+1];
		return Fibonacci_Series(num, memo);
	}
	
	public int Fibonacci_Series(int num,int[] memo){
		if(num==0){
			return 0;
		}else{
			if(num==1){
				return 1;
			}else{
				if(memo[num]==0){
						memo[num] = Fibonacci_Series(num-1, memo)+Fibonacci_Series(num-2, memo);
				}
					return memo[num];
				}
		}
	}
}
