public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if(n!=0)
            matrix[0][0] = 1;
        else
            return matrix;
        int i = 0;
        int j = -1;
        int tmp = 1;
        for(int k = 0; k < n ; k++){
            matrix[0][++j]=tmp++;
        }
        while(true){
            n--;
            if(n==0)
                break;
            for(int k = 0; k < n ; k++){
                matrix[++i][j] = tmp++;
            }
            for(int k = 0; k < n ; k++){
                matrix[i][--j] = tmp++;
            }
            n--;
            if(n==0)
                break;
            for(int k = 0; k < n ; k++){
                matrix[--i][j] = tmp++;
            }
            for(int k = 0; k < n ; k++){
                matrix[i][++j] = tmp++;
            }
        }
        return matrix;
    }
}