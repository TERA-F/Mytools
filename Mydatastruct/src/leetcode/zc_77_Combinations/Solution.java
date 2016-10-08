public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(k>n) return ret;
        boolean[] mask = new boolean[n];
        helper(ret,new ArrayList<Integer>(),mask,k,0);
        return ret;
    }
    
    private void helper(List<List<Integer>> ret, ArrayList<Integer> tmp, boolean[] mask, int k,int pos){
        if(k == 0){
            ret.add(new ArrayList<Integer>(tmp));
        }
        
        for(int i = pos ; i < mask.length ; i++){
            if(!mask[i]){
                mask[i] = true;
                tmp.add(i+1);
                helper(ret,tmp,mask,k-1,i+1);
                tmp.remove(tmp.size()-1);
                mask[i] = false;
            }
        }
    }
}
