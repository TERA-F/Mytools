class Solution {
public:
    int uniquePaths(int m, int n) {

        if(n==0|m==0)
            return 0;
        if(m>n){
            int tmp = m;
            m = n;
            n = tmp;
        }
        long ret = 1;
        int tmp = m+n-2;
        for(int i = 1; i< m; ++i){
            ret = ret * tmp-- / i;
        }
        return (int)ret;
    }
};
