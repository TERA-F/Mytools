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
    public int minDepth(TreeNode root) {
        if(root == null )return 0;
        if(root.left == null && root.right ==null) return 1;
        return Math.min(helper(root.left,1),helper(root.right,1));
    }
    
    private int helper(TreeNode node,int val){
        if(node == null) return Integer.MAX_VALUE;
        if(node.left == null && node.right ==null )return val+1;
        return Math.min(helper(node.left,val+1),helper(node.right,val+1));
    }
}
