public class Solution {
    private static final int [][] dirs = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
    
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> ret = new ArrayList<int[]>();
        if(matrix.length == 0 || matrix[0].length ==0) return ret;
        boolean [][] p = new boolean[matrix.length][matrix[0].length];
        boolean [][] a = new boolean[matrix.length][matrix[0].length];
        
        for(int i = 0 ; i <matrix.length ; i++)  mark(matrix,i,0,p);
        for(int i = 0 ; i <matrix[0].length ; i++)  mark(matrix,0,i,p);
        
        for(int i = 0 ; i <matrix.length ; i++)  mark(matrix,i,matrix[0].length-1,a);
        for(int i = 0 ; i <matrix[0].length ; i++)  mark(matrix,matrix.length-1,i,a);
        
        for(int i = 0 ; i < matrix.length ; i++)
            for(int j = 0 ; j <matrix[0].length ; j++){
                if(p[i][j]&&a[i][j]){
                    int[] tmp = new int[]{i,j};
                    ret.add(tmp);
                }
            }
        return ret;
    }
    
    private void mark(int[][] matrix,int i,int j,boolean[][] p){
        if(p[i][j] == true) return;
        p[i][j] = true;
        for(int[] dir:dirs){
            int x=i+dir[0],y=j+dir[1];
            if(x>=0 && x< matrix.length && y>=0 && y<matrix[0].length && matrix[x][y] >= matrix[i][j]){
                mark(matrix,x,y,p);
            }
        }
    }
    
}

