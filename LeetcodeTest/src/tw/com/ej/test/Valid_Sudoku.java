package tw.com.ej.test;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Valid_Sudoku {
	
	
	    public boolean isValidSudokuSimpe(char[][] board) {
	        int n = 9;
	        HashSet<Character>[] row = new HashSet[n];
	        HashSet<Character>[] col = new HashSet[n];
	        HashSet<Character>[] box = new HashSet[n];
	        
	        for(int i=0; i<n ; i++){
	            row[i] = new HashSet<>();
	            col[i] = new HashSet<>();
	            box[i] = new HashSet<>();
	        }
	        
	        for(int r=0; r<n; r++){
	            
	            for(int c=0; c<n; c++){
	                char val = board[r][c];
	                if(val == '.') continue;
	                if(row[r].contains(val)){
	                    return false;
	                }
	                row[r].add(val);
	                if(col[c].contains(val)){
	                    return false;
	                }
	                col[c].add(val);
	                int boxIndex = (r/3)*3+(c/3);
	                if(box[boxIndex].contains(val)){
	                    return false;
	                }
	                box[boxIndex].add(val);
	            }
	        }
	        return true;
	    }
	
	
	//短但執行慢且耗記憶體多
	public boolean isValidSudoku(char[][] board) {
		Set<String> seen = new HashSet<String>();
	    for (int i=0; i<9; ++i) {
	        for (int j=0; j<9; ++j) {
	            if (board[i][j] != '.') {
	                String b = "(" + board[i][j] + ")";
	                if (!seen.add(b + i) || !seen.add(j + b) || !seen.add(i/3 + b + j/3))
	                    return false;
	            }
	        }
	    }
	    return true;
		
	}
}
