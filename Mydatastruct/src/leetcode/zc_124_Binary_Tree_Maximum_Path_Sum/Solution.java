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
    private int sum;
    public int maxPathSum(TreeNode root) {
        sum = Integer.MIN_VALUE;
        helper(root);
        return sum;
    }
    
    private int helper(TreeNode root){
        if(root == null) return 0;
        int left = Math.max(0,helper(root.left));
        int right = Math.max(0,helper(root.right));
        sum = Math.max(sum,left+right+root.val);
        return Math.max(left,right)+root.val;
    }
}
