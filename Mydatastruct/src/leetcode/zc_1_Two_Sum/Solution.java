public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int[] ret = new int[2];
        for(int i = 0 ; i < nums.length ; ++i){
            if(map.containsKey(nums[i])){
                ret[0] = map.get(nums[i]);
                ret[1] = i;
                return ret;
            }else{
                map.put(target-nums[i],i);
            }
        }
        return ret;
    }
}