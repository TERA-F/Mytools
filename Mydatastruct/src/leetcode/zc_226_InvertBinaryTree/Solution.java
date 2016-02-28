package leetcode.zc_226_InvertBinaryTree;

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
    public TreeNode invertTree(TreeNode root) {
        if(root!=null)
        {
            if((root.left!=null)||(root.right!=null))
                help(root);
        }
        else
        {
            return null;
        }
        return root;
    }
    
    public void help(TreeNode hassubtree)
    {
        TreeNode temp = hassubtree.left;
        hassubtree.left = hassubtree.right;
        hassubtree.right = temp;
        if(hassubtree.left!=null)
            help(hassubtree.left);
        if(hassubtree.right!=null)
            help(hassubtree.right);
    }
}