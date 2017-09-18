package trees;
/*Find a path between two nodes in a Graph using Depth First Search*/
import java.util.HashSet;
public class DFS {
	public boolean hasDFS(int source, int destination){
		HashSet<Integer> visited = new HashSet<Integer>();
		/*check Graph.java for Graph's implementation*/
		Graph graph = new Graph();
		Graph.Node s = graph.getNode(source);
		Graph.Node d = graph.getNode(destination);
		return hasDFS(s,d, visited);
	}
	
	/*Instead of a flag I used a HashSet since it's more convenient to use as compared to a flag.*/
	public boolean hasDFS(Graph.Node source, Graph.Node destination, HashSet<Integer> visited){
		if(visited.contains(source.id)){
			return false;
		}
		visited.add(source.id);
		
		if(source==destination){
			return true;
		}
		
		for(Graph.Node child:source.adjacent){
			if(hasDFS(child,destination,visited)){
				return true;
			}
		}
		return false;
	}
}
