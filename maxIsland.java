package leetcode;

public class maxIsland {
	public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
       
        int max= 0;
        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                max = Math.max(max, getArea(grid, row, col));
            }
        }
        return max;
    }
    
    private int getArea(int[][] grid,int row, int col){
        int count = 0;
        if(row>=0 && row<grid.length && col>=0 && col<grid[0].length && grid[row][col]==1){
            grid[row][col] = 0; 
            count = 1+ getArea(grid, row-1, col) + getArea(grid, row, col-1) + getArea(grid, row+1, col) +                                              getArea(grid, row, col+1);
            return count;
        }
        return 0;
    }
}
