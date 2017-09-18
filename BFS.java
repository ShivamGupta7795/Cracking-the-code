package trees;
import java.util.HashSet;
import java.util.LinkedList;
public class BFS {
	public boolean BFSpath(int source, int destination){
		Graph graph = new Graph();
		return BFSpath(graph.getNode(source), graph.getNode(destination));
	}
	
	/*In bread first approach, visit the first node add it to the list/queue. Check if the
	 * destination node is same as current node, if so return true otherwise check if the
	 * node is already visited. If the current node is already visited then continue the loop
	 * and traverse the next element of the list/queue. If current node is not visited then 
	 * mark the node as visited and add all the adjacent child in the list/queue. Repeat the loop
	 * until all the nodes are visited or destination node is reached. Return false if control
	 * comes out of the loop.*/
	private boolean BFSpath(Graph.Node source, Graph.Node destination){
		HashSet<Integer> visited = new HashSet<Integer>();
		LinkedList<Graph.Node> nodetovisit = new LinkedList<Graph.Node>();
		nodetovisit.add(source);
		while(!nodetovisit.isEmpty()){
					
			Graph.Node node = nodetovisit.remove();
			
			if(node==destination){
				return true;
			}
			
			if(visited.contains(node.id)){
				continue;
			}
			visited.add(node.id);
			for(Graph.Node child: node.adjacent){
				nodetovisit.add(child);
			}
		}
		
		return false;
		
	}
}
