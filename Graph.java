package trees;
import java.util.HashMap;
import java.util.LinkedList;
public class Graph {
	HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	
	public static class Node{
		int id;
		LinkedList<Node> adjacent = new LinkedList<Node>();
		public Node(int id){
			this.id  = id;
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
