public class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length<=1) return true;
        for(int i = nums.length-2 ; i>=0 ; --i){
            if(nums[i]==0){
                int tmp = 1;
                while(nums[i]<tmp){
                    --i;
                    tmp++;
                    //System.out.println(i);
                    if(i<0) return false;
                }
            }
        }
        return true;
    }
}