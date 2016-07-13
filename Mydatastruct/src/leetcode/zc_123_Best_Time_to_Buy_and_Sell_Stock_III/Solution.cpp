class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int maxpro = 0;
        int k = 2;
        int tmp = 0;
        if(prices.size()<2)
            return 0;
        else{
            vector<vector<int>> f(k+1,vector<int>(prices.size(),0));
            for(int kk = 1; kk < k+1 ; ++kk){
                tmp = f[kk-1][0] - prices[0];
                for(int ii = 1 ; ii < prices.size() ; ++ii){
                    f[kk][ii] = max(f[kk][ii-1],prices[ii]+tmp);
                    tmp = max(tmp,f[kk-1][ii] - prices[ii]);
                    maxpro = max(maxpro,f[kk][ii]);
                }
            }
        }
        return maxpro;
    }
};