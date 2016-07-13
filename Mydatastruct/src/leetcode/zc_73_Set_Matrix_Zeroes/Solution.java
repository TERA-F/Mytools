public class Solution {
    public void setZeroes(int[][] matrix) {
        int x;
        int y;
        if((x = matrix.length)==0 || (y = matrix[0].length)==0) return;
        int[] inx = new int[x];
        int[] iny = new int[y];
        for(int i : inx) i=0;
        for(int i : iny) i=0;
        for(int i = 0 ; i < x; ++i){
                for(int j = 0 ; j < y ;  ++j){
                        if(matrix[i][j]==0){
                            inx[i]=1;
                            iny[j]=1;
                            //System.out.println("i"+i+"j"+j);
                        }
                }
        }
        
        for(int k = 0; k< x ; ++k){
            System.out.print("  indx"+k+":"+inx[k]);
            if(inx[k]==1){
                for(int l =0 ; l < y ; ++l)
                    matrix[k][l]=0;
            }
        }
        System.out.println();
        for(int k = 0; k< y ; ++k){
            System.out.print("  indy"+k+":"+iny[k]);
            if(iny[k]==1){
                for(int l =0 ; l < x ; ++l)
                    matrix[l][k]=0;
            }
        }
    }
}