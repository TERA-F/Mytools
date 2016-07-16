public class Solution {
    public int removeDuplicates(int[] nums) {
        int len;
        boolean flag = false;
        if((len=nums.length)==0) return 0;
        int del = 0;
        for(int i = 1 ; i < len ; ++i){
            if(nums[i]==nums[i-1-del]){
                if(flag == true){
                    del++;
                }
                else
                    flag = true;
            }else{
                flag = false;
            }
            nums[i-del] = nums[i];
        }
        return len-del;
    }
}