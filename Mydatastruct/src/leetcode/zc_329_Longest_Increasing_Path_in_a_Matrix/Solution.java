public class Solution {

    static final private int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public int longestIncreasingPath(int[][] matrix) {
        int m;
        int n;
        if((m = matrix.length) == 0) return 0;
        if((n = matrix[0].length) == 0) return 0;
        int[][] p = new int[m][n];
        int max = 1;
        for(int i = 0 ; i < m ; i++)
            for(int j = 0 ; j < n ;j++){
                int len = helper(matrix,i,j,m,n,p);
                max = Math.max(len,max);
            }
        return max;
    }
    
    private int helper(int[][] mat,int i, int j,int m, int n,int[][] p){
        if(p[i][j]!=0) return p[i][j];
        int max = 1;
        for(int [] d : dir){
            int x = i + d[0];
            int y = j + d[1];
            if(x < 0 || x >= m || y < 0 || y >= n || mat[x][y] <= mat[i][j]) continue;
            int len = 1 + helper(mat,x,y,m,n,p);
            max = Math.max(max,len);
        }
        p[i][j] = max;
        return max;
    }
}
