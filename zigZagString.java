package leetcode;
/*
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 *  (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * */
public class zigZagString {
	 public String convert(String s, int numRows) {
	        if(numRows==1 || s.length()<2)
	            return s;
	        StringBuilder[] sb = new StringBuilder[numRows];
	        
	        for(int i=0;i<numRows;i++){
	            sb[i] = new StringBuilder();
	        }
	        int i=0;
	        while(i<s.length()){
	                for(int j=0;j<numRows && i<s.length();j++){
	                    sb[j].append(s.charAt(i));
	                    i++;
	                }
	                for(int k=numRows-2;k>0 && i<s.length();k--){
	                    sb[k].append(s.charAt(i));
	                    i++;
	                }
	        }
	        StringBuilder result = new StringBuilder();
	        for(i=0;i<numRows;i++){
	            result.append(sb[i].toString());
	        }
	        return result.toString();
	        
	    }
}
