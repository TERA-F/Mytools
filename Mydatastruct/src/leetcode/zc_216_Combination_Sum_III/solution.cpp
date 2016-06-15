class Solution {
public:
    vector<vector<int>> combinationSum3(int k, int n) {
        vector<vector<int>> ret;
        vector<int> addret;
        helper(ret,addret,1,k,n);
        return ret;
    }
    
    void helper(vector<vector<int>> & ret, vector<int> & addret, int pre, int k, int target){
        if(target == 0 && k == 0){
            ret.push_back(addret);
            return;
        }
        for(int i=pre; i <= 10 -k && i <= target ; i++){
            addret.push_back(i);
            helper(ret,addret,i+1,k-1,target-i);
            addret.pop_back();
        }
    }
};
