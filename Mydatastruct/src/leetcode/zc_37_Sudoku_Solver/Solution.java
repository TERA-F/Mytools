public class Solution {
    public void solveSudoku(char[][] board) {
        if(board==null || board.length!=9 || board[0].length!=9) return;
        solver(board);
    }
    
    private boolean solver(char[][]board){
        for(int i = 0 ; i < 9 ; ++i)
            for(int j = 0 ; j < 9 ; ++j)
                if(board[i][j]=='.'){
                    for(char k = '1' ; k <= '9' ; ++k)
                        if(isValied(board,i,j,k)){
                            board[i][j] = k;
                            
                            if(solver(board)) return true;
                            else board[i][j] = '.';
                        }
                    return false;
                }
        return true;
    }
    
    private boolean isValied(char[][] board, int i, int j, char k){
        for(int l = 0 ; l < 9 ; ++l)
            if(board [i][l] == k) return false;
        
        for(int l = 0 ; l < 9 ; ++l)
            if(board [l][j] == k) return false;
            
        for(int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++)
            for(int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++)
                if(board[row][col] == k)
                    return false;

        return true;
    }
}
