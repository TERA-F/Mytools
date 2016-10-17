public class Solution {
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length <2) return 0;
        
        int m = nums[0];
        for( int x : nums)
            m = Math.max(x,m);
        
        int[] aux = new int[nums.length];
        int exp = 1;
        while(m /exp > 0 ){
            int[] count = new int[10];
            
            for(int i = 0 ; i < nums.length ; i++){
                count[(nums[i]/exp)%10]++;
            }
            
            for(int i = 1 ; i < count.length ; i++){
                count[i] += count[i-1];
            }
            
            for(int i = nums.length - 1 ; i >= 0 ; i--){
                aux[--count[(nums[i]/exp)%10]] = nums[i];
            }
            
            for(int i = 0 ; i < nums.length ; i++){
                nums[i] = aux[i];
            }
            exp *=10;
        }
        int ret = 0;
        for(int i = 1 ; i < nums.length ; i++){
            ret = Math.max(ret,nums[i]-nums[i-1]);
        }
        return ret;
    }
}
