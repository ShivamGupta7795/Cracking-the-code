package CTC;
/*delete a node from middle if head is not given*/
public class Delete_Node_In_Middle {
	public static void main(String[] ar){
		
	}
	public static Node deletenodeinmiddle(Node node){
		if(node.next!=null){
			node.data = node.next.data;
			node.next = node.next.next;
			return node;
		}
		/*can't delete last node*/
		return null;
	}
}
