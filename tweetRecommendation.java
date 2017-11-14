package leetcode;
import java.util.*;
public class tweetRecommendation {
	public ArrayList<String> recommendTweet(String[][] followGraph, String[][] likeGraph, String targetUser, int likeThreshold){
		HashSet<String> neighbourSet = new HashSet<String>();
		HashMap<String, Integer> tweetMap = new HashMap<String, Integer>();
		
		for(String[] tuple: followGraph){
			if(tuple[0].equals(targetUser))
				neighbourSet.add(tuple[1]);
		}
		
		if(neighbourSet.size()<likeThreshold)
			return new ArrayList<String>();
		
		for(String[] tuple: likeGraph){
			if(neighbourSet.contains(tuple[0])){
				tweetMap.put(tuple[1], tweetMap.getOrDefault(tuple[1], 0)+1);
			}
		}
		
		return sortMapByValues(tweetMap, likeThreshold);
	}
	
	public ArrayList<String> sortMapByValues(HashMap<String, Integer> map, int likeThreshold){
		List<Map.Entry> list = new LinkedList(map.entrySet());
		/*sort collection by values*/
		Collections.sort(list, (o1, o2) -> (-1)*((Comparable) ((Map.Entry)o1).getValue()).compareTo(((Map.Entry)o2).getValue()));
		
		ArrayList<String> result = new ArrayList<String>();
		for(Map.Entry object: list){
			if((int)object.getValue() >= likeThreshold){
				result.add((String)object.getKey());
			}else{
				break;
			}
		}
		return result;
	}
	
}
