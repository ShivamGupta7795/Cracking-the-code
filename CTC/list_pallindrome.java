package CTC;
import java.util.Stack;

public class list_pallindrome {
	public static void main(String[] ar){
		Node list = new Node(1);
		list.next = new Node(2);
		list.next = new Node(2);
		list.next = new Node(3);

		System.out.println(new list_pallindrome().pallindrome(list));
	}
	public boolean pallindrome(Node list){
		Node slow = list;
		Node fast = list;
		Stack<Integer> stack = new Stack();
		while(fast!=null&&fast.next!=null){
			stack.add(slow.data);
			fast = fast.next.next;
			slow = slow.next;
		}
		if(fast!=null){
			slow = slow.next;
		}
		while(slow!=null){
			int top = (Integer)stack.pop();
			if(slow.data!=top){
				return false;
			}
			slow= slow.next;
		}
		return true;
	}
}
