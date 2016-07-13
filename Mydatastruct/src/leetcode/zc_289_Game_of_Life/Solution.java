public class Solution {
    public void gameOfLife(int[][] board) {
        int x;
        int y;
        if((y = board[0].length)==0 || (x = board.length)==0)
            return;
        int tmp = 0;
        
        for(int i = 0 ; i < x ; ++i)
            for(int j = 0 ; j < y ; ++j){
                tmp = getnei(board,i,j);
                if( ((board[i][j] & 1) ==0) && tmp == 3) board[i][j] = board[i][j] | 2 ;
                if( (board[i][j] & 1)==1 && (tmp ==2 || tmp == 3)) board[i][j] = board[i][j] | 2;
        }
        
        for(int i = 0 ; i < x ; ++i)
            for(int j = 0 ; j < y ; ++j){
                board[i][j] = board[i][j] >> 1;
        }
    }
    
    int getnei(int[][] board, int i, int j){
        int ret = 0;
        for(int k = i-1; k < i+2 ; ++k)
            for(int l = j-1 ; l < j+2 ; ++l){
                if( k<0 || l<0 || k>board.length-1 || l>board[0].length-1 || (k==i&&l==j)) continue;
                if( (board[k][l] & 1)==1) ret++;
        }
        return ret;
    }
}