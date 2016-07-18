public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n;
        if((n=obstacleGrid.length)==0) return 0;
        int m;
        if((m=obstacleGrid[0].length)==0) return 1;
        
        int[][] mat = new int[n][m];
        
        if(obstacleGrid[0][0]==1) return 0;
        mat[0][0] = 1;
        
        for(int i = 1; i < n; i++){
            mat[i][0] = mat[i-1][0];
            if(obstacleGrid[i][0]==1) mat[i][0]=0;
            //System.out.println("i:"+i+"j:"+0+":"+mat[i][0]);
        }
        for(int i = 1; i < m; i++){
            mat[0][i] = mat[0][i-1];
            if(obstacleGrid[0][i]==1) mat[0][i]=0;
            //System.out.println("i:"+0+"j:"+i+":"+mat[0][i]);
        }
        
        for(int i = 1; i < n ;i++ )
            for(int j = 1; j <m ; j++){
                if(obstacleGrid[i][j] == 1){
                    mat[i][j]=0;
                    //System.out.println("i:"+i+"j:"+j+":"+mat[i][j]);
                }else{
                    mat[i][j] = mat[i-1][j]+mat[i][j-1];
                    //System.out.println("i:"+i+"j:"+j+":"+mat[i][j]);
                }
            }
        return mat[n-1][m-1];
    }
}