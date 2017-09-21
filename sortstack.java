package stack;

public class sortstack {
	stack buffer;
	
	public sortstack(){
		buffer = new stack();
	}
	
	public stack sort(stack s){
		while(s.peek()!=null){
			int temp = s.pop().data;
			if(buffer.peek()!=null&&buffer.peek().data<temp){
				while(buffer.peek()!=null&&temp>buffer.peek().data){
					s.push(buffer.pop().data);
				}
			}
			buffer.push(temp);
		}
		return buffer;
	}
	
}
