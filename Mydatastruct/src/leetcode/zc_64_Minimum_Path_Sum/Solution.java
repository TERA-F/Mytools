public class Solution {
    public int minPathSum(int[][] grid) {
        int m;
        int n;
        if((n=grid.length)==0|(m=grid[0].length)==0)
            return 0;
        System.out.println(m);
        System.out.println(n);
        for(int i = 1; i < n ; i++)
            grid[i][0] = grid[i-1][0]+grid[i][0];
        for(int i = 1; i < m ; i++)
            grid[0][i] = grid[0][i-1]+grid[0][i];
        for(int i = 1;i < n ; i++){
            for(int j = 1;j < m; j++){
                grid[i][j] = Math.min(grid[i-1][j],grid[i][j-1])+grid[i][j];
            }
        }
        return grid[n-1][m-1];
    }
}