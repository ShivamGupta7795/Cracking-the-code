import java.util.HashSet;
public class DFS {
	public boolean hasDFS(int source, int destination){
		HashSet<Integer> visited = new HashSet<Integer>();
		Graph graph = new Graph();
		Graph.Node s = graph.getNode(source);
		Graph.Node d = graph.getNode(destination);
		return hasDFS(s,d, visited);
	}
	
	public boolean hasDFS(Graph.Node source, Graph.Node destination, HashSet<Integer> visited){
		if(visited.contains(source.id)){
			return false;
		}
		visited.add(source.id);
		for(Graph.Node child:source.adjacent){
			if(hasDFS(child,destination,visited)){
				return true;
			}
		}
		return false;
	}
}
