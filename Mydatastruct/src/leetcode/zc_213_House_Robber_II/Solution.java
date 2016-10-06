public class Solution {
    public int rob(int[] nums) {
        if( nums.length == 1) return nums[0];
        return Math.max(helper(nums,1,nums.length-1),helper(nums,0,nums.length-2));
    }
    
    private int helper(int[] nums , int lo , int hi){
        int include=0,exclude=0;
        for(int j = lo ; j <= hi ; j++){
            int i = include;
            int e = exclude;
            exclude = Math.max(i,e);
            include = e+nums[j];
        }
        return Math.max(include,exclude);
    }
}
