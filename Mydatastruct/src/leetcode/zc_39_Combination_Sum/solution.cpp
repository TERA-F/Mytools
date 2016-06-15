class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> ret;
        vector<int> addret;
        sort(candidates.begin(),candidates.end());
        helper(ret,addret,candidates,0,target);
        return ret;
    }
    
    void helper(vector<vector<int>> & ret,vector<int> & addret,vector<int>& candidates, int posnum, int target){
        if(target == 0){
            ret.push_back(addret);
            return ;
        }
        for(int i = posnum ; i < candidates.size(); i++){
            if(target - posnum<0)
                break;
            addret.push_back(candidates[i]);
            helper(ret,addret,candidates,i,target-candidates[i]);
            addret.pop_back();
        }
    }
};
