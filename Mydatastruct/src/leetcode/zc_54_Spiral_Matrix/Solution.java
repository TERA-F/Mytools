public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m, n;
        if ((m = matrix.length) == 0 || (n = matrix[0].length) == 0) {
            return new ArrayList<>();
        }
        List<Integer> order = new ArrayList<>();
        int dm = m;
        int dn = n;
        int i = 0;
        int j = -1;
        while(true){
            for(int k = 0; k < dn ; ++k){
                j++;
                order.add(matrix[i][j]);
            }
            dm--;
            if( dm <= 0)
                break;
            for(int k = 0; k < dm ; ++k){
                i++;
                order.add(matrix[i][j]);
            }

            dn--;
            if( dn <= 0)
                break;
            for(int k = 0; k < dn; ++k){
                j--;
                order.add(matrix[i][j]);
            }

            dm--;
            if( dm <= 0)
                break;
            for(int k = 0; k < dm ; ++k){
                i--;
                order.add(matrix[i][j]);
            }
            dn--;
            if( dn <= 0)
                break;
        }
        return order;
    }
}