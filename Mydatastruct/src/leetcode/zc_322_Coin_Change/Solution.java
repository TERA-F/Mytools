public class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] ret = new int[amount+1];
        Arrays.fill(ret,Integer.MAX_VALUE);
        ret[0] = 0;
        
        for(int coin:coins)
            for(int i = coin;i<=amount;i++){
                if(ret[i-coin]!=Integer.MAX_VALUE){
                    ret[i] = Math.min(ret[i],ret[i-coin]+1);
                }
            }
        return ret[amount]==Integer.MAX_VALUE?-1:ret[amount];
    }
}
