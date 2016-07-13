public class Solution {
    public void rotate(int[][] matrix) {
        int n;
        int tmp;
        if((n=matrix.length)==0)
            return ;
        if(n%2==0){
            for(int i = 0;i < n/2;++i)
                for(int j = 0 ; j < n/2 ; ++j){
                    tmp = matrix[i][j];
                    matrix[i][j] = matrix[n-1-j][i];
                    matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                    matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                    matrix[j][n-1-i] = tmp;
                }
        }else{
            for(int i = 0;i <= n/2;++i)
                for(int j = 0 ; j < n/2 ; ++j){
                    tmp = matrix[i][j];
                    matrix[i][j] = matrix[n-1-j][i];
                    matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                    matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                    matrix[j][n-1-i] = tmp;
                }
        }
    }
}