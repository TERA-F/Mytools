public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<String>();
        if(nums.length<1) return ret;
        int curr = nums[0];
        int first = nums[0];
        for(int i = 1 ; i < nums.length ; ++i){
            if(curr != nums[i]-1){
                if(curr == first)   ret.add(first+"");
                else    ret.add(first+"->"+nums[i-1]);
                first = nums[i];
            }
            curr = nums[i];
        }
        if(curr == first)   ret.add(curr+"");
        else    ret.add(first+"->"+nums[nums.length-1]);
        return ret;
    }
}