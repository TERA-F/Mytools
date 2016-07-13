public class Solution {
    public void moveZeroes(int[] nums) {
        int gap = 0;
        for(int i = 0; i < (nums.length); i++)
        {
            nums[i-gap]=nums[i];
            if(nums[i]==0)
            {
                gap++;
            }
        }
        for(int i = nums.length-gap;i<nums.length;i++)
            nums[i]=0;
    }
}