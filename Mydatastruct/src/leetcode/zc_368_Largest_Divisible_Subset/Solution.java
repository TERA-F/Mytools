public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();
        if(nums.length == 0) return ret;
        if(nums.length == 1){
          ret.add(nums[0]);
          return ret;
        } 
        int [] len = new int[nums.length];
        int [] nextindex = new int[nums.length];
        int max =0;
        int index = -1;
        Arrays.sort(nums);
        for(int i = nums.length-1 ; i >= 0 ; --i){
            for(int j = i ; j < nums.length ; ++j){
                if(nums[j] % nums[i] == 0 && len[i]< 1 + len[j]){
                    len[i] = 1+len[j];
                    nextindex[i] = j;
                    if(len[i]>max){
                        max = len[i];
                        index = i;
                    }
                }
            }
        }
        for( int i = 0; i < max ; i++){
            ret.add(nums[index]);
            index = nextindex[index];
        }
        return ret;
    }
}
