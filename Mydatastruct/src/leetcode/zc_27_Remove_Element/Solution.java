public class Solution {
    public int removeElement(int[] nums, int val) {
        int len;
        int del = 0;
        if((len=nums.length)==0) return 0;
        for(int i = 0 ; i < len ; ++i){
            nums[i-del] = nums[i];
            if(nums[i]==val){
                del++;
            }
        }
        for(int i = len - del; i < len ;++i){
            nums[i] = 0;
        }
        return len -del;
    }
}