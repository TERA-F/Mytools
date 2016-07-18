public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size;
        if((size = triangle.size())==0) return 0;
        int[] nums = new int[size];
        
        for(int each : nums)
            each = 0;
        nums[0] = triangle.get(0).get(0);
        
        for(int i = 1 ; i < size ; ++i)
            for(int j =i ; j >=0 ; --j){
                if(j == i){
                    nums[j] = nums[j-1]+triangle.get(i).get(j);
                }else if(j == 0 ){
                    nums[0] = triangle.get(i).get(0)+nums[0];
                }else{
                    nums[j] = Math.min(nums[j-1]+triangle.get(i).get(j),nums[j]+triangle.get(i).get(j));
                }
            }
        
        int minret = Integer.MAX_VALUE;
        for(int each : nums)
            if(minret > each)
                minret = each;
        return minret;
    }
}