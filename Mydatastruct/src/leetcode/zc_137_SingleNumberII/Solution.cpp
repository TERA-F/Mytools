class Solution {
public:
    int singleNumber(vector<int>& nums) {
        auto r = 0, k = 3;
        for (auto i = 0; i < 32; ++i) {
            auto mask = 1 << i, cnt = 0;

            for (auto num : nums)
                cnt += bool(num & mask);

            if (cnt % k)
                r |= mask;
        }
        return r;
    }
};