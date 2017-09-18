package stack;
public class stack<D>{
	stack<D> top;
	stack<D> next;
	D data;
	
	public stack(D data){
		this.data = data;
		top = this;
	}
	
	public void push(D data){
		stack<D> node = new stack<D>(data);
		node.next = top;
		top = node;
	}
	
	public stack<D> pop(){
		if(top!=null){
			stack<D> item = top;
			top = top.next;
			return item;
		}
		return null;	
	}
	
	public stack<D> peek(){ 
		if(top!=null){
			return top;
		}
		return null;
	}
	
}