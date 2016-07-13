public class Solution {
    public void sortColors(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int tmp;
        while(i<j){
            while(i < j && nums[i]==0) ++i;
            while(i < j && nums[j]!=0) --j;
            if(i < j ){
                tmp =  nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        i = 0;
        while(i < nums.length && nums[i]==0) ++i;
        j = nums.length - 1;
        while(i<j){
            while((i < j) && nums[i]==1) ++i;
            while((i < j) && nums[j]!=1) --j;
            if(i < j ){
                tmp =  nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        
    }
}