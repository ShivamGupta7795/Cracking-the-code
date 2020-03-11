package CTC;

import java.util.HashMap;

// find number of ways to put parenthesis around boolean expression to get desired result
// eg "1^0|0|1", false => 2
// solution check page 286
public class BooleanEvaluation {

	public static void main(String[] ar) {
		String exp = "0&0&0&1^1|0";
		System.out.println(new BooleanEvaluation().getBooleanEval(exp, true, new HashMap<>()));
	}
	
	public int getBooleanEval(String exp, boolean res, HashMap<String, Integer> map) {
		if(exp.isEmpty()) return 0;
		if(exp.length() == 1) return strToBool(exp) == res ? 1:0;
		
		if(map.containsKey(exp+res)) {
			return map.get(exp+res);
		}
		
		int ways = 0;
		
		for(int i=1;i<exp.length(); i+=2) {
			char op = exp.charAt(i);
			String left = exp.substring(0,i);
			String right = exp.substring(i+1);
			
			int leftFalse = getBooleanEval(left, false, map);
			int rightFalse = getBooleanEval(right, false,  map);
			int leftTrue = getBooleanEval(left, true, map);
			int rightTrue = getBooleanEval(right, true, map);
			
			int totalWays = (leftTrue+leftFalse) * (rightTrue+rightFalse);
			int trueWays = 0;
			
			
			if(op == '^') {
				trueWays = (leftFalse*rightTrue) + (rightFalse*leftTrue);
			}
			
			if(op=='|') {
				trueWays = (leftFalse*rightTrue) + (leftTrue*rightFalse) + (rightTrue*leftTrue);
			}
			
			if(op=='&') {
				trueWays = (leftTrue*rightTrue);
			}
			
			if(res) {
				ways += trueWays;
			} else {
				ways += totalWays - trueWays;
			}
		}
		map.put(exp+res, ways);
		return ways;
	}
	
	public boolean strToBool(String s) {
		return s.equals("1") ? true : false;
	}
}
