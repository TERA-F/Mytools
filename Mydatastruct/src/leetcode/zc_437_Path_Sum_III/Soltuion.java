/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int nodesum = 0;
    private int target;
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        List<Integer> ret = new ArrayList<Integer>();
        target = sum;
        helper(ret,root);
        return nodesum;
    }
    
    private void helper(List<Integer>ret,TreeNode node){
        if(node == null) return ;
        ret.add(node.val);
        int tmp = 0;
        for(int i = ret.size() - 1 ; i >=0;i--){
            tmp += ret.get(i);
            if(tmp == target) nodesum++; 
        }
        helper(new ArrayList<Integer>(ret),node.left);
        helper(new ArrayList<Integer>(ret),node.right);
    }
}
