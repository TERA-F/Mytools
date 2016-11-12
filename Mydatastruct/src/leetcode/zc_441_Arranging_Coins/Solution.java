public class Solution {
    public int arrangeCoins(int n) {
        int ret = 0;
        int num = 0;
        while(num<n){
            ret++;
            num++;
            n -= num;
        }
        return ret;
    }
}
