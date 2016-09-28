public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon==null || dungeon.length<1 || dungeon[0].length<1) return 0;
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = (1 - dungeon[m-1][n-1])>0 ? 1 - dungeon[m-1][n-1] : 1;
        for(int i = m-2 ; i >= 0 ; i--)
            dp[i][n-1] = (dp[i+1][n-1]-dungeon[i][n-1])>0 ? dp[i+1][n-1]-dungeon[i][n-1] : 1 ;
        for(int i = n-2 ; i >= 0 ; i--)
            dp[m-1][i] = (dp[m-1][i+1]-dungeon[m-1][i])>0 ? dp[m-1][i+1]-dungeon[m-1][i] : 1 ;
        for(int i = m-2 ; i >= 0 ; i--)
            for(int j = n-2 ; j >= 0 ; j--){
                dp[i][j] = (Math.min(dp[i+1][j],dp[i][j+1]) - dungeon[i][j])>0 ? (Math.min(dp[i+1][j],dp[i][j+1]) - dungeon[i][j]) :1;
            }
        // System.out.println(dp[0][0]);
/*        for(int i = 0 ; i < m; i++){
            for(int j = 0 ; j < n; j++){
                System.out.print("  "+dp[i][j]);
            }
            System.out.println();
        }*/
        return dp[0][0];
    }
}
