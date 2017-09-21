package stack;

public class towerofHanoi {
	
	public static void main(String[] ar){
		int n=3;
		towerofHanoi[] tower = new towerofHanoi[n];
		for(int i=0;i<n;i++){
			tower[i] = new towerofHanoi(i);
		}
		
		for(int i=n;i>=0;i--){
			tower[0].add(i);
		}
		tower[0].movedisks(n,tower[2],tower[1]);
	}
	
	
	
	stack disk;
	int id;
	public towerofHanoi(int i){
		disk = new stack();
		id = i;
	}
	
	public int getid(){
		return id;
	}
	
	public boolean add(int data){
		if(disk.top.data>data){
			return false;
		}
		disk.push(data);
		return true;
	}
	
	public boolean movetotop(towerofHanoi t){
		stack top = disk.pop();
		return t.add(top.data);
	}
	
	public void movedisks(int n, towerofHanoi destination, towerofHanoi buffer){
		if(n>0){
			movedisks(n-1,buffer, destination);
			movetotop(destination);
			movedisks(n, destination, buffer);
		}
	}	
}
