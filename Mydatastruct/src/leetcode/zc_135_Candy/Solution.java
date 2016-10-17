public class Solution {
    public int candy(int[] ratings) {
        int[] ret = new int[ratings.length];
        Arrays.fill(ret,1);
        for(int i = 1 ; i < ret.length ; i++){
            if(ratings[i]>ratings[i-1])
                ret[i] = ret[i-1]+1;
        }
        for(int i = ret.length-1 ; i>0; i--){
            if(ratings[i-1]>ratings[i])
                ret[i-1] = Math.max(ret[i]+1,ret[i-1]);
        }
        int sum = 0;
        for(int i = 0 ; i < ret.length ; i++){
            // System.out.println(ret[i]+" ");
            sum += ret[i];
        }
        return sum;
    }
}
