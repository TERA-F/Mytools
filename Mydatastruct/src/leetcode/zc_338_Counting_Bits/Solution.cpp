class Solution {
public:
    vector<int> countBits(int num) {
        vector<int>result(num+1,0);
        if(num==0)
            return result;
        result[1]=1;
        if(num==1)
            return result;
        int Powerint = 2,Atint = 2;
        while(Atint <= num)
        {
            if(Atint>=Powerint)
                Powerint =Powerint * 2;
            result[Atint]=result[Atint-Powerint/2]+1;
            Atint++;
        }
        return result;
    }
};