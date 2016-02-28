package leetcode.zc_104_MaximumDepthofBinaryTree;

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
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        if ((root.left==null)&&(root.right==null))
            return 1;
        else
        {
            int leftdep;
            int rightdep;
            if(root.left==null)
                leftdep = 0;
            else
                leftdep = maxDepth(root.left);
            if(root.right==null)
                rightdep = 0;
            else
                rightdep = maxDepth(root.right);
            return (leftdep>rightdep?leftdep:rightdep)+1;
        }
    }
}