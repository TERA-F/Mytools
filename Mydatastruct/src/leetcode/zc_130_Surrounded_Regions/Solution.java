public class Solution {
/*    private static int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

    public void solve(char[][] board){
        int m;
        int n;
        if( (m=board.length)==0 || (n=board[0].length)==0 ) return;
        boolean[][] marked = new boolean[m][n];
        for(int i = 0; i<m ;i++) mark(marked,board,i,0);
        for(int j = 0; j<n ;j++) mark(marked,board,0,j);
        for(int i = 0; i<m ;i++) mark(marked,board,i,n-1);
        for(int j = 0; j<n ;j++) mark(marked,board,m-1,j);
        
        for(int i = 0 ; i < m ; i++)
            for(int j = 0 ; j < n ; j++){
                if(board[i][j]=='O'&& marked[i][j] == false) board[i][j] = 'X';
                if(board[i][j]=='A') board[i][j] = 'O';
            }
    }
    
    private void mark(boolean[][] marked , char[][] board ,int i ,int j){
        if(marked[i][j] == true) return;
        // System.out.println(i+" "+j);
        marked[i][j] = true;
        if(board[i][j] == 'X') return ;
        if(board[i][j] == 'O'){
            board[i][j] = 'A';
            for(int[] dir:dirs){
                int x = i + dir[0],y = j + dir[1];
                if(x<0 || x >=marked.length || y<0 || y >=marked[0].length )continue;
                mark(marked,board,x,y);
            }
        }
    }*/ // same idea but get StackOverflowError.
    public void solve(char[][] board) {
    	if (board.length == 0 || board[0].length == 0)
    		return;
    	if (board.length < 2 || board[0].length < 2)
    		return;
    	int m = board.length, n = board[0].length;
    	//Any 'O' connected to a boundary can't be turned to 'X', so ...
    	//Start from first and last column, turn 'O' to '*'.
    	for (int i = 0; i < m; i++) {
    		if (board[i][0] == 'O')
    			boundaryDFS(board, i, 0);
    		if (board[i][n-1] == 'O')
    			boundaryDFS(board, i, n-1);	
    	}
    	//Start from first and last row, turn '0' to '*'
    	for (int j = 0; j < n; j++) {
    		if (board[0][j] == 'O')
    			boundaryDFS(board, 0, j);
    		if (board[m-1][j] == 'O')
    			boundaryDFS(board, m-1, j);	
    	}
    	//post-prcessing, turn 'O' to 'X', '*' back to 'O', keep 'X' intact.
    	for (int i = 0; i < m; i++) {
    		for (int j = 0; j < n; j++) {
    			if (board[i][j] == 'O')
    				board[i][j] = 'X';
    			else if (board[i][j] == '*')
    				board[i][j] = 'O';
    		}
    	}
    }
    //Use DFS algo to turn internal however boundary-connected 'O' to '*';
    private void boundaryDFS(char[][] board, int i, int j) {
    	if (i < 0 || i > board.length - 1 || j <0 || j > board[0].length - 1)
    		return;
    	if (board[i][j] == 'O')
    		board[i][j] = '*';
    	if (i > 1 && board[i-1][j] == 'O')
    		boundaryDFS(board, i-1, j);
    	if (i < board.length - 2 && board[i+1][j] == 'O')
    		boundaryDFS(board, i+1, j);
    	if (j > 1 && board[i][j-1] == 'O')
    		boundaryDFS(board, i, j-1);
    	if (j < board[i].length - 2 && board[i][j+1] == 'O' )
    		boundaryDFS(board, i, j+1);
    }
}
