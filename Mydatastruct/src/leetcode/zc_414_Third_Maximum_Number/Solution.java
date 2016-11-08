public class Solution {
/*    public int thirdMax(int[] nums) {
        PriorityQueue<Long> pq = new PriorityQueue<Long>(new Comparator<Long>(){
            @Override
            public int compare(Long v1,Long v2){
                return (int)(v2-v1);
            }
        });
        for(int i : nums)
            if(!pq.contains((long)i))pq.offer((long)i);
        System.out.println(pq.size());
        for(long i : pq)
            System.out.println(i);
        if(pq.size()>2){
            pq.poll();
            pq.poll();
            System.out.println("pass");
        }
        long ret;
        ret = pq.peek();
        return (int)ret;
    }*///cant'work , i don't know why;
    public int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
    }
}
