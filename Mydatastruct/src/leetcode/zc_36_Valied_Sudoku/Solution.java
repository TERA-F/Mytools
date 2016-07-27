public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board==null || board.length!=9 || board[0].length!=9) return false;
        
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][][] box = new boolean[3][3][9];
        for(int i = 0 ; i < 9 ; ++i)
            for(int j = 0 ; j < 9 ; ++j){
                char tmp = board[i][j];
                if(tmp >= '1' && tmp <= '9' ){
                    int check = tmp - '1';
                    if(row[i][check]) return false;
                    row[i][check] = true;
                    if(col[check][j]) return false;
                    col[check][j] = true;
                    System.out.println("row:"+check+"col:"+j);
                    if(box[i/3][j/3][check]) return false;
                    box[i/3][j/3][check] = true;
                    
                }else if(tmp!= '.') return false;
            }

        return true;
    }
}public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board==null || board.length!=9 || board[0].length!=9) return false;
        
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][][] box = new boolean[3][3][9];
        for(int i = 0 ; i < 9 ; ++i)
            for(int j = 0 ; j < 9 ; ++j){
                char tmp = board[i][j];
                if(tmp >= '1' && tmp <= '9' ){
                    int check = tmp - '1';
                    if(row[i][check]) return false;
                    row[i][check] = true;
                    if(col[check][j]) return false;
                    col[check][j] = true;
                    System.out.println("row:"+check+"col:"+j);
                    if(box[i/3][j/3][check]) return false;
                    box[i/3][j/3][check] = true;
                    
                }else if(tmp!= '.') return false;
            }

        return true;
    }
}
