package CTC;
public class list_partition {
	public static void main(String[] ar){
		
	}
	
	public Node partitionlist(Node list, int data){
		Node lessthan = null;
		Node greaterthan = null;
		Node lessthanhead = null;
		Node greaterthanhead = null;
		Node pivot = null;
		while(list!=null){
			if(list.data==data){
				 pivot = list;
			}
			list = list.next;
		}
		if(pivot==null){
			return null;
		}
		
		while(list!=null){
			Node nextnode = list.next;
			list.next = null;
			if(list.data<data){
				if(lessthan!=null){
					lessthan.next = list;
				}else{
					lessthan = list;
					lessthanhead = lessthan;
				}
				lessthan = lessthan.next;
			}else{
				if(greaterthan!=null){
					greaterthan.next = list;
				}else{
					greaterthan = list;
					greaterthanhead = greaterthan;
				}
				greaterthan = greaterthan.next;
			}
			list = nextnode;
		}
		if(lessthan==null){
			pivot.next = greaterthanhead;
			return pivot;
		}
		lessthan.next = pivot;
		pivot.next = greaterthanhead;
		return lessthanhead;			
	}
}

