package CTC;
import java.util.*;
// create subsets of a given set
public class PowerSet {

	public static void main(String[] ar) {
		PowerSet ob = new PowerSet();
	
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		result.add(new ArrayList<>());
		ob.createSubSet(list, result);
		System.out.println("size: "+result.size());
		for(List<Integer> child : result) {
			for(int i: child) {
				System.out.print(i+" ");
			}
			System.out.println(" ");
		}
	}
	
	public List<List<Integer>> createSubSet(List<Integer> list, List<List<Integer>> result) {
		
		for(int i=0;i<list.size();i++) {
			List<List<Integer>> temp = new ArrayList<>();
			for(List<Integer> child: result) {
				List<Integer> subres = new ArrayList<>();
				subres.addAll(child);
				subres.add(list.get(i));
				temp.add(subres);
			}
			result.addAll(temp);
		}
		
		return result;
	}
}
