package CTC;
import java.util.HashSet;

/*remove duplicates from an unsorted linked list*/
public class remove_duplicate {
	public static void main(String[] ar){
		Node list= new Node(0);
		list.appendtotail(5);
		list.appendtotail(2);
		list.appendtotail(3);
		list.appendtotail(2);
		list.appendtotail(5);
		
		list = removeduplicate(list);
		while(list!=null){
			System.out.println(list.data);
			list= list.next;
		}
	}
	
	public static Node removeduplicate(Node list){
		Node head = list;
		Node prev = list;
		/*method 1 using hashset*/
		
//		HashSet<Integer> set = new HashSet();
//		
//		while(list!=null){
//			if(set.contains(list.data)){
//				prev.next = list.next;
//			}else{
//				set.add(list.data);
//				prev = list;
//			}
//			list = list.next;
//		}
		
		/*method 2: Using bit manipulation*/
		int check = 0;
		while(list!=null){
			int val = 1<<list.data;
			if((check&val)!=0){
				prev.next = list.next;
			}else{
				prev = list;
				check |= val;
			}
			list = list.next;
		}
		
		
		return head;
	}
}
