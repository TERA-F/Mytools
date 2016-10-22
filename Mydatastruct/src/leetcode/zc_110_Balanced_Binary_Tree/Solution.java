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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int leftdep = finddepth(root.left,0);
        int rightdep = finddepth(root.right,0);
        if(leftdep-rightdep>1 || rightdep-leftdep>1) return false;
        if(!isBalanced(root.left)) return false;
        if(!isBalanced(root.right)) return false;
        return true;
    }
    
    private int finddepth(TreeNode root, int dep){
        if(root==null) return dep;
        return Math.max(finddepth(root.left,dep+1),finddepth(root.right,dep+1));
    }
    
/*    private boolean diff(TreeNode root, int curr , int dep){
        if(root ==null){
            if(curr==dep || curr==(dep-1))
                return true;
            return false;
        }
        if(!diff(root.left,curr+1,dep)) return false;
        if(!diff(root.right,curr+1,dep)) return false;
        return true;
    }*/
}
