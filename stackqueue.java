package stack;

public class stackqueue {
	stack addstack;
	stack substack;
	public stackqueue(){
		addstack = new stack();
		substack = new stack();
	}
	public void add(int data){
		addstack.push(data);
	}
	public int remove(){
		if(substack==null){
			while(addstack!=null){
				substack.push(addstack.pop().data);
			}
		}
		return substack.pop().data;
	}
	
}
