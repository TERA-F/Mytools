public class Solution {
/*    static int count;
    public int combinationSum4(int[] nums, int target) {
        if(nums==null || nums.length <1) return 0;
        helper(nums,target,0,0);
        return count;
    }
    private void helper(int[] nums,int target, int pos,int val){
        if(val == target){
            count++;
            return;
        }
        if(val > target || pos == nums.length)
            return;
        
        for(int i = pos ;i < nums.length ; i++){
            val = nums[pos]+val;
            helper(nums,target,pos,val);
            helper(nums,target,pos+1,val);
        }
    }*/
/*    public int combinationSum4(int[] nums, int target){
        if(target == 0 )
            return 1;
        int ret = 0 ;
        for(int i = 0 ; i < nums.length ; i++){
            if(target >= nums[i])
                ret += combinationSum4(nums, target - nums[i]);
        }
        return ret;
    }*/
    private int[] dp;

    public int combinationSum4(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(nums, target);
    }
    
    private int helper(int[] nums, int target) {
        if (dp[target] != -1) {
            return dp[target];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += helper(nums, target - nums[i]);
            }
        }
        dp[target] = res;
        return res;
    }
}
