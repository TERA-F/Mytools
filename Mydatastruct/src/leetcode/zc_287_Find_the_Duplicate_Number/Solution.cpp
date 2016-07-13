class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        for(auto it=nums.begin();it!=nums.end();it++)
            if(*it==*(it+1))
                return *it;
        return 0;
    }
};