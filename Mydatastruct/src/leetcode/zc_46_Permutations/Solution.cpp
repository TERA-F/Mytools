class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> res;
        helper(res,nums,0);
        return res;
    }
    
    void helper(vector<vector<int>> & res, vector<int> & nums, int pos){
        if(pos==nums.size()){
            res.push_back(nums);
        }else{
            for(int i = pos;i<nums.size();i++){
                swap(nums[pos],nums[i]);
                helper(res,nums,pos+1);
                swap(nums[pos],nums[i]);
            }
        }
    }
};