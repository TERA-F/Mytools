public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int x,y;
        if((x=matrix.length)==0 || (y=matrix[0].length)==0) return false;
        
        int low, high, mid;
        boolean condition;
        low = 0;
        high = x-1;
        while(low < high){
            mid = (high + low) / 2;
            if(matrix[mid][0] >= target){
                high = mid;
            }else{
                low = mid;
            }
            //System.out.println("xhigh"+high+"  xmid"+mid+"  xlow"+low);
            if((low+1)==high){
                if(matrix[high][0] > target)
                    high = low;
                else
                    low = high;
            }
        }
        //System.out.println("xhigh"+high+"  xlow"+low);
        
        int tarx = low;
        for(int i = 0 ; i < y; ++i){
            if(matrix[tarx][i]==target)
                return true;
        }
        //System.out.println("yhigh"+high+"  ylow"+low);
        
        return false;
    }
}