package CTC;
public class string_compress {
	public static void main(String[] str){
		System.out.println(compress_string("aaa"));
	}
	public static String compress_string(String str){
		if(str.length()==0||str.length()==1){
			return str;
		}
		StringBuilder sb = new StringBuilder();
		int count =1;
		for(int i=1;i<str.length();i++){
			if(str.charAt(i)==str.charAt(i-1)){
				count++;
			}else{
				sb.append(str.charAt(i-1)+Integer.toString(count));
				count = 1;
			}
		}
		sb.append(str.charAt(str.length()-1)+Integer.toString(count));
		return sb.toString().length()<str.length()?sb.toString():str;
	}
}
