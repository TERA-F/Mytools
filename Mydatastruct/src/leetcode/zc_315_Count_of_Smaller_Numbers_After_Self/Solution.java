public class Solution {
    class Node{
        Node left,right;
        int val,sum,dup=1;
        public Node(int v, int s ){
            this.val = v;
            this.sum = s;
        }
    }
    
     public List<Integer> countSmaller(int[] nums){
         Integer [] ans = new Integer[nums.length];
         Node root = null;
         for(int i = nums.length - 1; i >= 0; i--){
             root = insert(nums[i],ans,root,i,0);
         }
         return Arrays.asList(ans);
     }
     private  Node insert(int num,Integer[] ans,Node node,int i, int preSum){
         if(node ==null){
             node = new Node(num,0);
             ans[i] = preSum;
         }else if(node.val == num){
             node.dup++;
             ans[i] = preSum + node.sum;
         }else if(node.val > num){
             node.sum++;
             node.left = insert(num,ans,node.left,i,preSum);
         }else{
             node.right = insert(num,ans,node.right,i,preSum + node.sum + node.dup);
         }
         return node;
     }
}
