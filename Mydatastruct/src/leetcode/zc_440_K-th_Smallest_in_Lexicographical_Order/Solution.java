public class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;
        while(k>0){
            int step = helper(n,curr,curr+1);
            if(step <= k){
                curr++;
                k -= step;
            }else{
                curr *= 10;
                k--;
            }
        }
        return curr;
    }
    
    private int helper(int n,long n1,long n2){
        int step = 0;
        while(n1<=n){
            step += Math.min(n2,n+1) - n1;
            n1 *= 10;
            n2 *= 10;
        }
        return step;
    }
}
