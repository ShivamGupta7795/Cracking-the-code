package trees;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*Non recursive approach for Depth First Search : https://www.youtube.com/watch?v=Y40bRyPQQr0*/
public class DFS_Stack {
	public void DFSPath(Graph.Node source, Graph.Node destination){	
		HashSet<Integer> visited = new HashSet<Integer>();
		Stack<Graph.Node> stack = new Stack<Graph.Node>();
		stack.push(source);
		
		while(!stack.isEmpty()){
			Graph.Node node = stack.peek();
			stack.pop();
			System.out.println(node.id);
			if(visited.contains(node.id)){
				continue;
			}
			visited.add(node.id);
			for(Graph.Node child: node.adjacent){
				if(!visited.contains(child)){
					stack.push(child);
				}
			}
			
		}
	}
}
