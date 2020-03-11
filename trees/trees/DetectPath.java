package trees;
import java.util.HashSet;
import java.util.LinkedList;
public class DetectPath {
	public static boolean checkpath(Graph.Node source, Graph.Node destination){
		HashSet<Graph.Node> visited = new HashSet<Graph.Node>();
//		return checkwithDFS(source, destination, visited);
		return checkwithBFS(source, destination,visited);
	}
	private static boolean checkwithDFS(Graph.Node source, Graph.Node destination, HashSet<Graph.Node> visited){
		if(source==destination){
			return true;
		}
		if(visited.contains(source)){
			return false;
		}
		visited.add(source);
		for(Graph.Node child:source.adjacent){
			if(checkwithDFS(child, destination, visited)){
				return true;
			}
		}
		return false;
	}
	
	private static boolean checkwithBFS(Graph.Node source, Graph.Node destination, HashSet<Graph.Node> visited){
		LinkedList<Graph.Node> queue = new LinkedList<Graph.Node>();
		queue.add(source);
		while(!queue.isEmpty()){
			Graph.Node node = queue.poll();
			if(visited.contains(node)) continue;
			if(node==destination) return true;
			visited.add(node);
			for(Graph.Node child: node.adjacent){
// 				if(!visited.contains(child)){
// 					if(child==destination){
// 						return true;
// 					}else{
// 						visited.add(child);
// 						queue.add(child);
// 					}	
// 				}
				queue.add(child);
			}
		}
		return false;
	}
} 
