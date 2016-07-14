public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(numRows==0) return ret;
        for(int i = 0 ; i < numRows ; ++i){
            List<Integer> tmp = new ArrayList<Integer>();
            for(int j =0 ; j< i +1 ; ++j){
                if(j==0|j==i){
                    tmp.add(1);
                }else{
                    tmp.add(ret.get(i-1).get(j-1)+ret.get(i-1).get(j));
                }
            }
            ret.add(tmp);
        }
        return ret;
    }
}