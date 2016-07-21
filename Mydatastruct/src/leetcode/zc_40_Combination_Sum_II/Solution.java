public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList();
        if(candidates.length<1) return ret;
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        Arrays.sort(candidates);
        helper(candidates,ret,tmp,target,0,0);
        return ret;
    }
    
    private void helper(int[] candidates,List<List<Integer>> ret, ArrayList<Integer> tmp,int target,int sum,int position){
        if(sum>target || position > candidates.length) return;
        if(sum==target){
            ArrayList<Integer> tmpret = new ArrayList<Integer>(tmp);
            ret.add(tmpret);
            return;
        }
        
        for(int i = position;i<candidates.length;i++){
            if(i > position && candidates[i] == candidates[i-1]) continue; /** skip duplicates */
            tmp.add(candidates[i]);
            sum += candidates[i];
            //System.out.println("tmp="+tmp+"sum="+sum+"target"+);
            helper(candidates,ret,tmp,target,sum,i+1);
            tmp.remove(tmp.size()-1);
            sum -= candidates[i];
        }
    }
}