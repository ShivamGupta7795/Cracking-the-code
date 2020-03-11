package CTC;
import java.util.*;
public class EightQueen {
	// given n queens and nxn square board, find all possible positions on square where queens will be safe
	
	public static void main(String[] ar) {
		
	}
	
	public List<List<QueenPoint>> nQueen(int n) {
		HashSet<Integer> bannedCol = new HashSet<>();
		HashSet<Integer> bannedDiagonal = new HashSet<>();
		List<QueenPoint> list = new ArrayList<>();
		List<List<QueenPoint>> result = new ArrayList<>();
		
		while(getQueenPos(0, bannedCol, bannedDiagonal, n, list)) {
			result.add(list);
			list = new ArrayList<>();
		}
		
		return result;
		
	}
	
	public boolean getQueenPos(int row, HashSet<Integer> bannedCols, HashSet<Integer> bannedDia, int n, List<QueenPoint> list) {
		if(row >= n) {
			return true;
		}
		
		for(int i=0;i<n;i++) {
			if(isValidPosition(row, i, bannedCols, bannedDia)) {
				bannedCols.add(i);
				bannedDia.add(i+row);
				bannedDia.add(row-i);
				list.add(new QueenPoint(row, i));
				if(getQueenPos(row+1, bannedCols, bannedDia, n, list)) {
					return true;
				}
				list.remove(list.size()-1);
				bannedCols.remove(i);
				bannedDia.remove(i+row);
				bannedDia.remove(row-i);
			}
		}
		
		return false;
	}
	
	
	
	public boolean isValidPosition(int row, int col, HashSet<Integer> bannedCol, HashSet<Integer> bannedDiagonal) {
		
		 if(bannedCol.contains(col)) {
			 return false;
		 }
		 
		 if(bannedDiagonal.contains(row-col) || bannedDiagonal.contains(row+col)) {
			 return false;
		 }
		
		return true;
		
	}
	
}

class QueenPoint {
	int x;
	int y;
	
	public QueenPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
