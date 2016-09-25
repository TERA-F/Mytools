public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> ret = new ArrayList<int[]>();
        if(nums1 == null || nums1.length<1 || nums2 == null || nums2.length<1) return ret;
        
        Comparator<int[]> cmp = new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                int sum1 = nums1[a[0]] + nums2[a[1]];
                int sum2 = nums1[b[0]] + nums2[b[1]];
                return sum1 - sum2;
            }
        };
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(cmp);
        for(int i = 0 ; i < nums1.length ; i++){
            pq.offer(new int[]{i,0});
        }
        while(!pq.isEmpty() && ret.size() < k) {
            int[] tmp = pq.poll();
            ret.add(new int[]{nums1[tmp[0]],nums2[tmp[1]]});
            tmp[1]++;
            if(tmp[1]!=nums2.length) pq.offer(tmp);
        }
        return ret;
    }
}
