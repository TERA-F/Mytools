public class Solution {
    private int num= 0;
    static final private int[][] dirs = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
    public int numIslands(char[][] grid) {
        if(grid.length ==0 ||grid[0].length == 0) return 0;
        int[][] cache = new int[grid.length][grid[0].length];
        for(int i = 0 ; i < grid.length ;i++){
            for(int j = 0 ; j < grid[0].length ;j++){
                helper(grid,cache,i,j);
            }
        }
        return num;
    }
    
    private void helper(char[][] grid,int[][] cache, int i, int j){
        if(grid[i][j]=='1' && cache[i][j] ==0){
            num++;
            mark(grid,cache,i,j);
        }
        
    }
    private void mark(char[][] grid, int[][] cache,int i,int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || cache[i][j]!=0) return;
        if(grid[i][j] == '1'){
            cache[i][j] = num;
            for(int[] dir : dirs){
                int x = i+dir[0];
                int y = j+dir[1];
                mark(grid,cache,x,y);
            }
        }
    }
}

