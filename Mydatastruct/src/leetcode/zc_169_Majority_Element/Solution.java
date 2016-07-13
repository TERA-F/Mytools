public class Solution {
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 1;

        for (int num : nums) {
            if (res == num) ++count;
            else --count;
            if (count == 0) {
                res = num;
                count = 1;
            }
        }

        return res;
    }
}