package CTC;
import java.util.*;

// find the shortest path in a grid from top left to bottom right with obstacles in between
public class RobotInGrid {

	int[] dir = {0,1,0,-1,0};
	int minPathLen = Integer.MAX_VALUE;
	ArrayList<Point> result = new ArrayList<>();
	
	public static void main(String[] ar) {
		int[][] grid = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		
		RobotInGrid ob = new RobotInGrid();
		
		
		ob.findShortestPath(grid);
		System.out.println(ob.result.size());
		for(int i=0;i<ob.result.size();i++) {
			System.out.println(ob.result.get(i).x+" "+ ob.result.get(i).y);
		}
	}
	
	
	public List<Point> findShortestPath(int[][] grid) {
		List<Point> list = new ArrayList<Point>();
		
		int minLen = getPathLength(grid, 0, 0, list);
		System.out.println("minLen "+ minLen);
		return list;
	}
	
	public int getPathLength(int[][] grid, int i, int j, List<Point> list) {
		if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == 1 || grid[i][j] == -1) {
			return Integer.MAX_VALUE;
		}
		
		if(i==grid.length -1 && j==grid[0].length -1) {
			list.add(new Point(i, j));
			
			if(minPathLen > list.size()) {
				minPathLen = list.size();
				result = new ArrayList<>(list);
			}
			
			return 1;
		}
		
		list.add(new Point(i, j));
		
		grid[i][j] = -1;
		
		int pathLen = Integer.MAX_VALUE - 1; 
		
		for(int k=0;k<dir.length-1;k++) {
			pathLen = Math.min(getPathLength(grid, i+dir[k], j+dir[k+1], list), pathLen);
		}
		pathLen += 1;
		list.remove(list.size() -1);
		
		
		grid[i][j] = 0;
		
		return pathLen;
	}
	
	
}

class Point {
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y =y;
	}
}
