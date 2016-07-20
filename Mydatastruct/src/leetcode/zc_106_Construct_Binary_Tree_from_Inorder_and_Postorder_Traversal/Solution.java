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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder,0,inorder.length-1,postorder,postorder.length-1);
    }
    
    private TreeNode helper(int[] inorder,int left, int right, int[] postorder, int lastroot){
        if(left>right) return null;
        TreeNode tmp = new TreeNode(postorder[lastroot]);
        if(left==right) return tmp;
        int nextroot = 0;
        for(int i = right; i >= left; --i)
            if(inorder[i]==postorder[lastroot]){
                nextroot = i;
                break;
            }
        tmp.right = helper(inorder,nextroot+1,right,postorder,lastroot-1);
        tmp.left = helper(inorder,left,nextroot-1,postorder,lastroot-(right-nextroot)-1);
        return tmp;
    }
}