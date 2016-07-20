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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(inorder,0,preorder.length-1,preorder,0);
    }
    
    private TreeNode helper(int[] inorder, int left, int right, int[] preorder, int lastroot){
        if(left>right) return null;
        TreeNode tmp = new TreeNode(preorder[lastroot]);
        if(left==right) return tmp;
        int nextroot = 0;
        for(int i = left; i<= right ; ++i)
            if(inorder[i]==preorder[lastroot]){
                nextroot = i;
            }
        tmp.left = helper(inorder,left,nextroot-1,preorder,lastroot+1);
        tmp.right = helper(inorder,nextroot+1,right,preorder,lastroot+(nextroot-left)+1);
        return tmp;
    }
}