public class Solution {

    private int[] ori;
    private Random rand = new Random();
    public Solution(int[] nums) {
        ori = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return ori;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] ret = new int[ori.length];
        if(ori.length <1) return ret;
        int loc = ret.length;
        LinkedList<Integer>tmp = new LinkedList<Integer>();
        for(int i: ori)
            tmp.add(i);
        for(int i = 0; i <ret.length ; i++){
            ret[i] = tmp.remove(rand.nextInt(tmp.size()));
        }
        // ret[0] = tmp.get(0);
        return ret;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
