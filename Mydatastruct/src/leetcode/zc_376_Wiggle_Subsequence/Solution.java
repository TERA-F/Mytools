public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length < 1 ) return 0;
        if(nums.length == 1) return 1;
        int len = 1;
        boolean flag = true;
        boolean init = false;
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i]-nums[i-1]!=0){
                if(!init){
                    init = true;
                    flag = (nums[i] - nums[i-1])>0;
                    len++;
                }else{
                    boolean tmp = (nums[i] - nums[i-1])>0;
                    if(tmp != flag) len++;
                    flag = tmp;
                }
            }
        }
        return len;
    }
}
