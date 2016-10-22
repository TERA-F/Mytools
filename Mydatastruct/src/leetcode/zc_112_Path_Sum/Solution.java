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
    private int target;
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        target = sum;
        if(root.left == null && root.right == null) return sum==root.val? true:false;
        if(helper(root.left,root.val) || helper(root.right,root.val)) return true;
        return false;
    }
    
    private boolean helper(TreeNode node, int val){
        if(node == null) return false;
        val += node.val;
        // System.out.println(val);
        if(node.left == null && node.right ==null && val == target) return true;
        if(helper(node.left,val) || helper(node.right,val)) return true;
        return false;
    }
}
