package leetcode;

public class LongestCommonPrefix {
	 public String longestCommonPrefix(String[] strs) {
//       StringBuilder result = new StringBuilder();
      
//        if(strs.length==0) return "";
//        String s = strs[0];
//        for(int i=0;i<s.length();i++){
//            for(int j=1;j<strs.length;j++){
//                if(i>=strs[j].length() || strs[j].charAt(i)!=s.charAt(i))
//                   return result.toString();
//            }
//            result.append(s.charAt(i));
//        }
//        return result.toString();
        if(strs == null || strs.length == 0)    return "";
  String pre = strs[0];
  int i = 1;
  while(i < strs.length){
      while(strs[i].indexOf(pre) != 0)
          pre = pre.substring(0,pre.length()-1);
      i++;
  }
  return pre;
       
  }
}
