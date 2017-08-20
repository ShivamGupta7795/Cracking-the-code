/*Customized Linked List*/
public class Node {
	int data;
	Node next;
	public Node(int data){
		this.data = data;
	}
	
	public void appendtotail(int data){
		Node newlink = new Node(data);
		Node current = this;
		while(current.next!=null){
			current = current.next;
		}
		current.next = newlink;
	}
	
	public Node delete(int data){
		Node current = this;
		Node head = this;
		if(current.data==data){
			return current.next;
		}
		while(current.next!=null){
			if(current.next.data==data){
				current.next = current.next.next;
				return head;
			}
			current = current.next;
		}
		return null;
	}
}
