public class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0,mask = 0;
        for(int i = 31; i >=0;i--){
            mask |= (1<<i);
            HashSet<Integer> set = new HashSet<Integer>();
            for(int num :nums){
                set.add(num & mask);
            }
            int tmp = max | (1<<i);
            for(int prefix :set){
                if(set.contains(tmp ^ prefix))
                    max = tmp;
            }
        }
        return max;
    }
}
