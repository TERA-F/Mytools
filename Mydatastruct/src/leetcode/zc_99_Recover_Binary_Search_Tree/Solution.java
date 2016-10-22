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
    private TreeNode first;
    private TreeNode second;
    private TreeNode tmp = new TreeNode(Integer.MIN_VALUE);
    
    public void recoverTree(TreeNode root) {
        if(root == null) return ;
        
        tarverse(root);
        int t = first.val;
        first.val = second.val;
        second.val = t;
    }
    
    private void tarverse(TreeNode root){
        if(root == null) return ;
        
        tarverse(root.left);
        
        if(first == null && tmp.val > root.val){
            first = tmp;
        }
        if(first != null && tmp.val > root.val){
            second = root;
        }
        
        tmp = root;
        
        tarverse(root.right);
    }
}
