package CTC;
import java.util.Stack;

public class linkedlist {
	linkedlist next;
	int data;
	
	public linkedlist(int data){
		this.data = data;
	}
	
	public void insertnode(int data){
		linkedlist node = new linkedlist(data);
		linkedlist curnode = this;
		
		while(curnode.next!=null){
			curnode = curnode.next;
		}
		curnode.next = node;
	}  
	
	/*return complete list after removing desired node*/
	public linkedlist deletenode(linkedlist head, int data){
		linkedlist first = head;
		if(head.data==data && head.next!=null){
			head.data = head.next.data;
			head.next = head.next.next;
			return head;
		}
		linkedlist prev = head;
		while(head!=null){
			if(head.data == data){
				prev.next = head.next;
				return first;
			}
			prev= head;
			head = head.next;
		}
		return first;
	}

	
	public linkedlist removeduplicate(linkedlist list){		
		
		/*approch 1 using buffer*/
//		boolean b[] = new boolean[128];
//		linkedlist head = list;
//		while(list!=null){
//			System.out.println(list.data);
//			if(b[list.data-'A']){
//				list.deletenode(head,list.data);
//			}else{
//				b[list.data-'A']= true;
//			}
//			list = list.next;
//		}
//		return head;
		
		/*removes duplicates without using explicit buffer*/
		int check =0;
		
		linkedlist head = list;
		
		while(list!=null){
			int val = 1<<list.data;
			if((check&val)!=0){
				list.deletenode(head, list.data);
			}
			check = check|val;
			list= list.next;
		}
		return head;
	}
	
//	public linkedlist removekfromlast(linkedlist list, int k){
//		/*method 1*/
////		linkedlist head = list;
////		linkedlist list2 = head;
////		while(list.next!=null){
////			if(k!=0){
////				k--;
////			}else{
////				list2 = list2.next;
////			}
////			list = list.next;
////		}
////		
////		if(k!=0){
////			return head;
////		}else{
////			list2 = list2.deletenode(head, list2.data);
////			return list2;
////		}	
//		
//		/*method 2: considering the fact that node count starts from 0*/
//		int count = 0;
//		linkedlist head = list;
//		linkedlist list2 = list;
//		while(list!=null){
//			if(count==k){
//				break;
//			}
//			count++;
//			list= list.next;
//		}
//		if(count!=k){
//			return null;
//		}
//		while(list!=null){
//			list2 = list2.next;
//			list = list.next;
//		}
//		return list;
//		
//		
//	}
	
	public void deletegivennode(linkedlist node){
		if(node.next!=null){
			node.next = node.next.next;
			node.next.data= node.data;
		}else{
			node = null;
		}
	}
	
	public linkedlist addnums(linkedlist l1, linkedlist l2){
		int carry = 0;
		linkedlist head = l1;
		while(l1!=null || l2!=null){
			l1.data = l1.data +l2.data + carry;
			if(l1.data>9){
				l1.data = l1.data%10;
				if(l1.next==null&&l2.next==null){
					l1.insertnode(1);
					break;
				}else{
					carry = 1;
				}	
			}else{
				carry = 0;
			}
			if(l1.next==null&&l2.next!=null){
				l1.insertnode(0);
			}
			if(l2.next==null&&l1.next!=null){
				l2.insertnode(0);
			}
			l1 = l1.next;
			l2 = l2.next;
		}
		return head;
	}
	
	public linkedlist addreversenums(linkedlist l1, linkedlist l2){
		
		linkedlist prev = new linkedlist(0);
		linkedlist head = prev;
		
		while(l1!=null || l2!=null){
			int val = l1.data + l2.data;
			if(val>9){
				prev.data += 1;
			}
			prev.insertnode(val%10);
			
			if(l1.next==null&&l2.next!=null){
				l1.insertnode(0);
			}
			if(l2.next==null&&l1.next!=null){
				l2.insertnode(0);
			}
			l1 = l1.next;
			l2 = l2.next;
			prev = prev.next;
		}
		if(head.data==0){
			return head.next;
		}
		return head;
	}
	
	public linkedlist returnhead(linkedlist l1){
		linkedlist prev = l1;
		while(l1!=null){
			l1 = l1.next.next;
			prev = prev.next;
			if(l1==prev){
				return l1;
			}
		}
		return l1;
	}
	
	public boolean checkpallindrome(linkedlist l1){
		/*using stack*/
		linkedlist slow = l1;
		linkedlist fast = l1;
		Stack<Integer> s = new Stack<Integer>();
		
		while(fast!=null && fast.next!=null){
			s.push(slow.data);
			fast = fast.next.next;
			slow = slow.next;
		}
		
		if(fast!=null){
			slow = slow.next;
		}
		
		while(slow!=null){
			int item = s.pop();
			System.out.println(item);
			if(item!=slow.data){
				return false;
			}
			slow = slow.next;
		}	
		return true;
	}
	
	public static void main(String[] ar){
		linkedlist list = new linkedlist(1);
		linkedlist list2 = new linkedlist(1);
		list.insertnode(2);
		list.insertnode(0);
//		list2.insertnode(4);
//		list2.insertnode();
		list.insertnode(2);
		list.insertnode(1);
		
		
		
		
//		linkedlist head = list;
//		
//		list= list.removeduplicate(list);
//		list = list.removekfromlast(list, 5);
//		list = list.addreversenums(list, list2);
		System.out.println(list.checkpallindrome(list2));
		while(list!=null){
			System.out.println(list.data);
			list = list.next;
		}
		
		
	}
	
}
