public class Solution {
    public int singleNumber(int[] nums) {
        int tmp=0;
        for(int num:nums)
            tmp ^=num;
        return tmp;
    }
}