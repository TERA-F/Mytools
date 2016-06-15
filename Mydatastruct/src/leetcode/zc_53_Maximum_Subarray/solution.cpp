class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        if(nums.empty())
            return -2147483648;
        if(nums.size()==1)
            return nums[0];
        int maxret = nums[0];
        int tmp = maxret;
        for(int i = 1 ; i < nums.size(); ++i){
            if(tmp>0)   tmp += nums[i];
            else if(tmp < nums[i])
                tmp = nums[i];
            maxret = max(maxret,tmp);
        }
        return maxret;
    }
};
