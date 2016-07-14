public class Solution {
    public int removeDuplicates(int[] nums) {
        int len;
        if((len=nums.length)==0) return 0;
        int del = 0;
        for(int i = 1 ; i < len ; ++i){
            if(nums[i]==nums[i-1-del]){
                del++;
            }else{
                nums[i-del] = nums[i];
                if(del!=0) nums[i] =0;
            }
        }
        return len-del;
    }
}