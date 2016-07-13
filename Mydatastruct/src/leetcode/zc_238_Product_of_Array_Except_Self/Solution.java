public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums==null)
            return null;
        int[] output = new int[nums.length];
        output[0] =1;
        for(int i = 1; i<nums.length; i++)
        {
            output[i] = nums[i-1]*output[i-1];
        }
        int tmp = 1;
        for(int i = nums.length-2; i>=0; i--)
        {
            tmp *= nums[i+1];
            output[i] *= tmp;  
        }
        return output;
    }
}