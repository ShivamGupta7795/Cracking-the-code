package stack;

public class MinStack extends stack {
	stack min = null;
	public MinStack(){
		 min = new stack();
	}
	public void push(int data){
		if(min.top.data > data){
			min.push(data);
		}
		super.push(data);
	}
	
	public stack pop(){
		stack item = super.pop();
		if(item!=null&&item.data==min.top.data){
			min.pop();
		}
		return item;
	}
	
}
