class Solution {
public:
    int climbStairs(int n) {
        int ret=0;
        int i = 0;
        helper(n,ret,i);
        return ret;
    }
    
    void helper(int & n, int & ret,int & i){
        if(i==n)
            ret++;
        if(i>n)
            return;
        helper(n,ret,i+1);
        helper(n,ret,i+2);
    }
};