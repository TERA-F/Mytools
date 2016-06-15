class Solution {
public:
    vector<int> grayCode(int n) {
        vector<int> ret(1,0);
        if(n == 0)
            return ret;
        ret.push_back(1);
        if(n == 1)
            return ret;
        int i = 2;
        helper(ret,i,n);
        return ret;
    }
    
    void helper(vector<int> & ret, int i, int n){
        if(i > n)
            return;
        int mask = 1<<(i-1);
        int tmp = ret.size();
        for(int i = tmp-1 ; i >= 0; --i){
            ret.push_back(ret[i]|mask);
        }
        helper(ret,i+1,n);
    }
};
