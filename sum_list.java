
public class sum_list {
	public static void main(String[] ar){
		Node list= new Node(9);
		Node list2= new Node(9);
		list.appendtotail(9);
		list.appendtotail(9);
		list2.appendtotail(3);
		list2 = sumlist(list, list2);
		while(list2!=null){
			System.out.println(list2.data);
			list2 = list2.next;
		}
	}
	
	/*adding the list when digits are store in reverse order*/
	public static Node sumlist(Node list1, Node list2){
		int carry = 0;
		Node prev = null;
		Node head = list2;
		while(list1!=null || list2!=null){
			int sum =0;
			sum += carry;
			if(list1!=null){
				sum +=list1.data;
				list1 = list1.next;
			}
			if(list2!=null){
				sum += list2.data;
				list2.data = sum%10;
				prev = list2;
				list2 = list2.next;
			}else{
				prev.next = new Node(sum%10);
				prev = prev.next;
			}
			
			carry = sum>9?1:0;	
		}
		if(carry==1){
			prev.next = new Node(1);
		}
		return head;
	}
	
//	/*adding the list when digits are arranged in forward manner*/
//	public static Node addlist(Node list1, Node list2){
//		int len1  = getlength(list1);
//		int len2  = getlength(list2);
//		if(len1>len2){
//			list1 = padlist(list2, len1-len2);
//		}else{
//			list2 = padlist(list1, len2-len1);
//		}
////		Node list = mergelist(list1, list2);
////		Node slow = list;
////		Node fast = list;
////		while(fast.next!=null&&fast.next.next!=null){
////			slow = slow.next;
////			fast = fast.next.next;
////		}
////		fast = list;
////		slow = slow.next;
////		int carry = 0;
////		while(slow.next!=null){
////			int sum = 0;
////			sum += slow.data+fast.data+carry;
////			carry = sum>9?1:0;
////			list1.data = sum%10;
////			list1
////			slow = slow.next;
////			fast = fast.next;
////		}
//	}
//	
//	public static int getlength(Node list){
//		int count = 0;
//		while(list!=null){
//			list = list.next;
//			count++;
//		}
//		return count;
//	}
//	
//	public static Node padlist(Node list, int pad){
//		Node padlist = null;
//		Node head = null;
//		for(int i=0;i<pad;i++){
//			if(padlist==null){
//				padlist = new Node(0);
//				head = padlist;
//			}else{
//				padlist.next = new Node(0);
//				padlist = padlist.next;
//			}
//		}
//		if(head!=null){
//			padlist.next = list;
//			list = head;
//		}
//		return list;
//	}
//	
//	public static Node mergelist(Node list1, Node list2){
//		Node head = list1;
//		while(list1.next!=null){
//			list1 = list1.next;
//		}
//		list1.next = list2;
//		return head;
//	}
}
