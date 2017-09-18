package leetcode;
import CTC.Node;
public class oddevenlist {
	public Node oddEvenList(Node head) {
        if(head==null){
            return head;
        } 
        Node odd = head;
        Node even = head.next;
        Node evenhead = even;
        while(odd.next!=null&&even.next!=null){
            
            odd.next = odd.next.next;
            odd = odd.next;
            
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenhead;
        return head;
    }
}
