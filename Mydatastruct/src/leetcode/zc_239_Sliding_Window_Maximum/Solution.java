public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0 || k ==0) return new int[0];
        PriorityQueue<Integer> p = new PriorityQueue<Integer>(k,new Comparator<Integer>(){
            @Override
            public int compare(Integer i ,Integer j){
                return j-i;
            }
        });
        for(int i  = 0; i < k - 1 ; i++){
            p.add(nums[i]);
        }
        int[] ret = new int[nums.length-k+1];
        for(int i = k-1; i < nums.length ; i++){
/*            for(int j : p)
                System.out.print(j);
            System.out.println();*/
            p.add(nums[i]);
            ret[i-k+1] = p.peek();
            p.remove(nums[i-k+1]);
        }
        return ret;
    }
}
