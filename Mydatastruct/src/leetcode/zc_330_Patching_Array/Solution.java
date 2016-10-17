public class Solution {
    public int minPatches(int[] nums, int n) {
        long misssum = 1;//int etl
        int i = 0;
        int added = 0;
        while(misssum<=n){
            if(i<nums.length && nums[i] <= misssum){
                misssum += nums[i++];
            }else{
                misssum += misssum;
                added++;
            }
        }
        return added;
    }
}
