public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if( k < 1 || t < 0)return false;
        HashMap<Long,Long> map = new HashMap<Long,Long>();
        for(int i = 0; i< nums.length ; i++){
            long remap = (long)nums[i] - Integer.MIN_VALUE;
            long bucket = remap /((long)t+1);
            if(map.containsKey(bucket)
                ||(map.containsKey(bucket - 1) && remap - map.get(bucket-1) <= t) 
                ||(map.containsKey(bucket + 1) && map.get(bucket+1) - remap <= t))
                return true;
            if(i >= k){
                long rm = ((long)nums[i-k]-Integer.MIN_VALUE)/((long)t+1);
                map.remove(rm);
            }
            map.put(bucket,remap);
        }
        return false;
    }
}
