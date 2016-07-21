public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length<1) return 0;
        
        int left=0,right=0,minlen = Integer.MAX_VALUE,sum=0;
        
        while(right<nums.length){
            sum += nums[right++];
            while(sum>=s){
                minlen = Math.min(minlen,right-left);
                sum -=nums[left++];
            }
        }
        return minlen==Integer.MAX_VALUE?0:minlen;
    }
}