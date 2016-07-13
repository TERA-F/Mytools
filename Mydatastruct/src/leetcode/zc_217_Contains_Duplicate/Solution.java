public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet set = new HashSet<Integer>();
        for(int i = 0; i < nums.length;i++)
            if(!set.add(nums[i])) return true;
        return false;
    }
}