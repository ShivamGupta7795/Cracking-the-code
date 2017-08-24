public class stack{
	stack top;
	stack next;
	int data;
	
	public stack(int data){
		this.data = data;
		top = this;
	}
	
	public void push(int data){
		stack node = new stack(data);
		node.next = top;
		top = node;
	}
	
	public stack pop(){
		if(top!=null){
			stack item = top;
			top = top.next;
			return item;
		}
		return null;	
	}
	
	public stack peek(){
		if(top!=null){
			return top;
		}
		return null;
	}
	
}