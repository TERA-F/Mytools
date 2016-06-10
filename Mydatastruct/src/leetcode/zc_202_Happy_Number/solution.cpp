class Solution {
public:
    bool isHappy(int n) {
        set<int> loopset;
        loopset.insert(n);
        return helper(n,loopset);
        
    }
    
    bool helper(int n, set<int> & loopdet )
    {
        if(n>3){
            vector<int> list;
            while(n>=10){
                int tmp = n%10;
                n = n/10;
                list.push_back(tmp);
            }
            list.push_back(n);
            int tmp = 0;
            for(auto x:list){
                tmp += x*x;
                cout<<x<<" ";
            }
            cout<<endl;
            if(loopdet.find(tmp)!=loopdet.end())
                return false;
            else
                loopdet.insert(tmp);
            return helper(tmp,loopdet);
            
        }else{
            if(n==1)
                return true;
            else
                return false;
        }
    }
};