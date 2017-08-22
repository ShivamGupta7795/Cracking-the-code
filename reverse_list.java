
public class reverse_list {
	public static void main(String[] ar){
		Node list= new Node(9);
		list.appendtotail(8);
		list.appendtotail(7);
		list = new reverse_list().reverselist(list);
		while(list!=null){
			System.out.println(list.data);
			list = list.next;
		}
	}
	public Node reverselist(Node list){
		Node prev = null;
		Node forward = null;
		while(list!=null){
			forward = list.next;
			list.next = prev;
			prev = list;
			list = forward;
		}
		return prev;
	}
}
