public class Solution {
    public int getMoneyAmount(int n) {
        int[][] list = new int[n+1][n+1];
        return DP(list,1,n);
    }
    
    private int DP(int[][] list,int l ,int r){
        if(l>=r) return 0;
        if(list[l][r] != 0) return list[l][r];
        int ret = Integer.MAX_VALUE;
        for(int i = l;i <= r;i++){
            int tmp = i + Math.max(DP(list,l,i-1),DP(list,i+1,r));
            ret = Math.min(ret,tmp);
        }
        list[l][r] = ret;
        return ret;
    }
}
