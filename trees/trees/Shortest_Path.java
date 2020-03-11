
package trees;
public class Shortest_Path {
	public static void main(String[] ar){
		
	}
	public int totalpaths(int[][] matrix, int row, int col){
		if(row==1 || col==1){
			return 1;
		}
		if(matrix[row][col]==0){
			matrix[row][col] = totalpaths(matrix, row+1, col) + totalpaths(matrix,row, col+1);
		}
		return matrix[row][col];
	}
	
}
