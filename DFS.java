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
	
	/*Intead of a flag I used a Hashset since it's more convinient to use as compared to a flag. A flag needs to be reset
	everytime after a loop which is not the case with hashset*/
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
