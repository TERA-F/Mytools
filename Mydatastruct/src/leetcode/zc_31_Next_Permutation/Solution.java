public class Solution {
    public void nextPermutation(int[] nums) {
      if(nums.length<2)  return;
      
      int i = nums.length-1;
      while(i>0){
          if(nums[i]>nums[i-1]) break;
          --i;
      }
      
      if(i!=0){
        for(int j = nums.length-1;j>i-1;j--){
            if(nums[j]>nums[i-1]){
                int tmp = nums[j];
                nums[j] = nums[i-1];
                nums[i-1] = tmp;
                break;
            }
        }
      }
      
      for(int j = nums.length-1;i<j;i++,j--){
          int tmp = nums[i];
          nums[i] = nums[j];
          nums[j] = tmp;
      }
    }
}