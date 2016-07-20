public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int [] ret = new int[2];
        ret[0] = -1;
        ret[1] = -1;
        if(nums.length<1) return ret;
        if(nums.length==1 && nums[0]==target){
            ret[0]= 0;
            ret[1]=0;
        }
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int mid = (left+right)/2;
            System.out.println(mid);
            if(nums[mid]==target){
                int retleft = mid;
                while(retleft>0 && nums[retleft-1]==nums[retleft]) retleft--;
                ret[0] = retleft;
                int retright = mid;
                while(retright<nums.length-1 && nums[retright+1]==nums[retright]) retright++;
                ret[1] = retright;
                break;
            }
            if(left+1==right){
                if(nums[right]==target){
                    ret[0] = right;
                    ret[1] = right;
                }
                break;
            }
            if(nums[mid]<target)
                left = mid;
            else
                right = mid;
        }
        return ret;
    }
}