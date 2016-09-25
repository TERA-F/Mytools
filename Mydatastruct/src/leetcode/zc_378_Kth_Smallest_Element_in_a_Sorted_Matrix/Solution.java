public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> que = new PriorityQueue();
        for(int i = 0 ; i < n ; i++) que.offer(new Tuple(0,i,matrix[0][i]));
        for(int i = 0 ; i < k - 1 ; i++){
            Tuple tmp = que.poll();
            if(tmp.x==n-1) continue;
            que.offer(new Tuple(tmp.x+1,tmp.y,matrix[tmp.x+1][tmp.y]));
        }
        return que.poll().val;
    }
    
    class Tuple implements Comparable<Tuple>{
        int x,y,val;
        public Tuple(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
        
        @Override
        public int compareTo(Tuple t){
            return this.val-t.val;
        }
    }
    
    
}
