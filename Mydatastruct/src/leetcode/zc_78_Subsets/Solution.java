public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> ret = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        helper(ret,nums,0,new ArrayList<Integer>());
        return ret;
    }
    
    protected void helper(ArrayList<List<Integer>> ret ,int[] nums, int n, ArrayList<Integer> tmp){
        if(n==nums.length){
            ret.add((List<Integer>)tmp.clone());
            return ;
        }
        tmp.add(nums[n]);
        helper(ret,nums,n+1,tmp);
        tmp.remove(tmp.size()-1);
        helper(ret,nums,n+1,tmp);
    }
}