package trees;
import java.util.HashMap;
import java.util.LinkedList;
public class Graph {
	static HashMap<Integer, Node> map;
	public void addNode(int id){
		Node node = new Node(id);
	}
	
	public Graph(){
		map = new HashMap<Integer, Node>();
	}
	
	public static class Node{
		public int id;
		public LinkedList<Node> adjacent = new LinkedList<Node>();
		public Node(int id){
			this.id  = id;
			map.put(id, this);
		}
	}
	
	public Node getNode(int id){
		return map.get(id);
	}
	
	public void addedge(int sourceid, int destinationid){
		Node source = getNode(sourceid);
		Node destination = getNode(destinationid);
		source.adjacent.add(destination);
	}
	
	
}
