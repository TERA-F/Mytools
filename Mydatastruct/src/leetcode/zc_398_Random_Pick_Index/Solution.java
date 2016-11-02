public class Solution {

    private int[] list;
    public Solution(int[] nums) {
        list = nums;
    }
    
    public int pick(int target) {
        int ret = 0;
        int count = 1;
        boolean flag= false;
        Random rand = new Random();
        for(int i = 0 ;i< list.length ; i++){
            if(list[i] == target){
                if(!flag){
                    ret = i;
                    flag = true;
                }
                else{
                    if(rand.nextInt(++count)==0)
                        ret = i;
                }
            }
        }
        return ret;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
