/*Find K last element from linked list
 * Approach: Maintain two pointers at a distance of k
 * return prev pointer once forward pointer reaches end*/
public class find_k_element {
	public static void main(String ar[]){
		Node list= new Node(0);
		list.appendtotail(5);
		list.appendtotail(2);
		list.appendtotail(3);
		list.appendtotail(2);
		list.appendtotail(5);
		System.out.println(findklastelement(list, 3).data);
	}
	public static Node findklastelement(Node list, int k){
		Node prev = list;
		
		while(list!=null){
			if(k==0){
				prev = prev.next;
			}else{
				k--;
			}
			list = list.next;
		}
		return prev;
	}
}
