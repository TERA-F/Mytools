class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        set<int> setnums1;
        set<int> resultset;
        vector<int> result;
        set<int>::iterator inti;
        for(int i : nums1)
            setnums1.insert(i);
        for(int i : nums2)
        {
            inti = setnums1.find(i);
            if(inti != setnums1.end())
                resultset.insert(*inti);
        }
        for(int i : resultset)
            result.push_back(i);
        return result;
    }
};