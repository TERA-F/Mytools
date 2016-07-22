public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0)    return res;
        backtrack(res, new ArrayList<Integer>(), 0, nums);
        return res;
    }
    
    private void backtrack(List<List<Integer>> res, List<Integer> temp, int pos, int[] nums){
        if(pos == nums.length){
            res.add(temp);
            return ;
        }
        
        int k = 0;
        for(int j=0;j<temp.size();j++){
            if(temp.get(j) == nums[pos])    k = j+1;    
        }
        for(int j=k;j<=temp.size();j++){
            temp.add(j, nums[pos]);
            backtrack(res, new ArrayList<>(temp), pos+1, nums);
            temp.remove(j);
        }
    }
}