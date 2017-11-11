package leetcode;
import java.util.ArrayList;
import java.util.HashMap;
/*Given a robot in a 2-d matrix. It can move down and right. Some points in matrix are blocked. Find if a path exists in
 * the matrix and how many paths exist.*/
public class getMatrixPath {
	public static boolean getPath(int[][] matrix, int x, int y, ArrayList<Points> paths, HashMap<Points, Boolean> map){
		/*Use map to mark the points in the matrix so as to avoid duplicate visits*/
		Points p = new Points(x,y);
		if(map.containsKey(p)) 
			return map.get(p);
		else{
			if(matrix[x][y]==-1)
				map.put(p, false);
			else
				map.put(p, true);
		}
		if(x==0 || y==0)
			return true;
		
		boolean path = false;
		
		path = getPath(matrix, x-1, y, paths, map) | getPath(matrix, x, y-1, paths, map); 
		if(path) paths.add(p);
		return path;
	}
	
	/*Count the number of paths from 0,0 to x,y*/
	public static int countPaths(int[][] matrix, int x, int y){
		if(x==0 || y==0) return 1;
		if(x<0 || y<0) return 0;
		if(!getPath(matrix, x, y, new ArrayList<Points>(), new HashMap<Points, Boolean>())){
			return 0;
		}
		if(matrix[x][y]!=0) return matrix[x][y];
		int count = 0;
		count = countPaths(matrix, x-1, y) + countPaths(matrix, x, y-1);
		return count;
	}
	
}


class Points{
	int x;
	int y;
	public Points(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	
	/*basic concept*/
	public int getTotalPaths(int[][] matrix, int x, int y){
		
		int path = 0;
	
		for(int i=1;i<x;i++){
			for(int j=1;j<y;j++){
				if(matrix[i][j]==-1)
					continue;
				matrix[i][j] += matrix[i-1][j] + matrix[i][j-1];
			}
		}
		/*if the end block is blocked then return 0 else return total paths to x,y*/
		if(matrix[x][y]==-1){
			return 0;
		}else{
			return matrix[x][y];
		}
		
		
		
	}
	
	
}

