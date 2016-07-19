public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int ret = 0 ;
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length - 2 ;++i){
            if(i!=0 && nums[i]==nums[i-1]) continue;
            int left = i+1;
            int right = nums.length - 1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                int tmp = Math.abs(sum-target);
                if(tmp < diff){
                  ret = sum;
                  diff = tmp;
                }
                if(sum < target){
                    left++;
                    while(left < right && nums[left]==nums[left-1]) left++;
                }else{
                    right--;
                    while(left < right && nums[right]==nums[right+1]) right--;
                }
            }
        }
        return ret;
    }
}