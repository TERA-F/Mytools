class Solution {
public:
    int integerBreak(int n) {
        int tmp=0,result=1;
        if(n==2)
            return 1;
        if(n==3)
            return 2;
        switch(n%3){
            case 0:
            {
                while(tmp!=n)
                {
                    tmp += 3;
                    result *=3;
                }
                return result;
                break;
            }
            case 1:
            {
                while(tmp!=(n-4))
                {
                    tmp += 3;
                    result *=3;
                }
                result *= 4;
                return result;
                break;
            }
            default:
            {
                while(tmp!=(n-2))
                {
                    tmp += 3;
                    result *=3;
                }
                result *= 2;
                return result;
            }
        }
    }
};