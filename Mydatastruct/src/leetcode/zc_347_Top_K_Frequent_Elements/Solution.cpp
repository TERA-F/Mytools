class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        map<int,int> mm;
        for(int i:nums)
        {
            if(mm.count(i))
            {
                //mm.emplace(pair<int,int>(i,mm.at(i)+1));
                mm.at(i) += 1;
            }
            else
            {
                mm.insert(pair<int,int>(i,1));
            }
//cout<<i<<":"<<mm.at(i)<<endl;
        }
        
        vector<int>result;
        //map<int,int>::iterator max=mm.begin(); Line 21: ¡®std::map<int, int>::iterator¡¯ has no member named ¡®second¡¯
        pair<int,int> max;

        for(int j= 0; j < k; j++)
        {
            max = pair<int,int>(0,0);
            for(pair<int,int>i:mm)
            {
                //((int)i.second()>(int)max.second())  expression cannot be used as a function
                if(i.second>max.second)
                    max = i;
//cout<<"pass this"<<endl;
            }
            result.push_back(max.first);
            mm.erase(mm.find(max.first));
        }   
        //max = new pair<int,int>(1,1);

        return result;
    }
};