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
    
    private int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null)
            sum +=root.val;
        if(root.left != null)
            helper(root.left,root.val);
        if(root.right != null)
            helper(root.right,root.val);
        return sum;
    }
    
    private void helper(TreeNode node , int val){
        if(node.left == null && node.right == null) 
            sum += val*10+node.val;
        if(node.left != null)
            helper(node.left,val*10+node.val);
        if(node.right != null)
            helper(node.right,val*10+node.val);
    }
}
