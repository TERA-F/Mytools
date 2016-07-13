class Solution {
public:
    int search(vector<int>& nums, int target) {
        if(nums.empty())
            return 0;
        for(int i = nums.size()-1; i >= 0; --i){
            if(target==nums[i])
                return i;
        }
        return -1;
    }
};