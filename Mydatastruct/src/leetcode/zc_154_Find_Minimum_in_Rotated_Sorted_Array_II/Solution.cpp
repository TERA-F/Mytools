class Solution {
public:
    int findMin(vector<int>& nums) {
        if(nums.empty())
            return 0;
        int min = nums[nums.size()-1];
        for(int i = nums.size()-2; i >= 0; --i){
            if(min>=nums[i])
                min = nums[i];
            else
                break;
        }
        return min;
    }
};