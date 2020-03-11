package CTC;

public class HexaDecimalToBinary {

	public static void main(String[] ar) {
		HexaDecimalToBinary ob = new HexaDecimalToBinary();
		
		System.out.println(ob.hexToDecimal("11"));
		System.out.println(ob.decimalToBinary(ob.hexToDecimal("F1")));
		System.out.println(ob.decimalToHex(32));
	}
	
	public int hexToDecimal(String hex) {
		
		String hexStr = "0123456789ABCDEF";
		int value = 0;
		
		for(int i=0;i<hex.length(); i++) {
			char digit = hex.charAt(i);
			int num = hexStr.indexOf(digit);
			value = value*16 + num;
		}
		
		return value;
	}
	
	public String decimalToBinary(int num) {
		String binary = new String();
		while(num>0) {
			binary = Integer.toString(num%2)+binary;
			num = num/2;
		}
		return binary;
	}
	
	
	public String decimalToHex(int num) {
		String hexStr = "0123456789ABCDEF";
		
		StringBuilder sb = new StringBuilder();
		while(num > 0) {
			char hexDigit = hexStr.charAt(num%16);
			sb.insert(0, hexDigit);
			num = num/16;
		}
		return sb.toString();
	}
	
	
}
