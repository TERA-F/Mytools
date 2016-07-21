public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        List<Integer> ret = new ArrayList<Integer>();
        if(nums.length<1) return ret;
        for(int x : nums){
            if(map.containsKey(x)){
                map.put(x,map.get(x)+1);
            }else{
                map.put(x,1);
            }
        }
        for(int x: map.keySet()){
            if(map.get(x)>(nums.length/3))
                ret.add(x);
        }
        System.out.println(nums.length/3);
        return ret;
    }
}