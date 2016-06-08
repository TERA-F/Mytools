class Solution {
public:
    int maxCoins(vector<int>& nums) {
        int num[nums.size()+2];
        int n = 1;
        for(int x:nums) if(x>0) num[n++]=x;
        num[0]=num[n++]=1;
        
        int dp[n][n]={};
        for(int i=2;i<n;i++)
            for(int left = 0;left<n-i;left++){
                int right = left + i;
                for(int j = left + 1; j < right;j++)
                    dp[left][right] = max(dp[left][right],num[left]*num[j]*num[right]+dp[left][j]+dp[j][right]);
            }
        return dp[0][n-1];
    }
};