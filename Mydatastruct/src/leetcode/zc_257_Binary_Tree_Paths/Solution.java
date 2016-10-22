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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<String>();
        if(root == null) return ret;
        String s = root.val+"";
        if(root.left == null && root.right == null){
            ret.add(s);
            return ret;
        }
        if(root.left != null) helper(ret,root.left,s);
        if(root.right != null) helper(ret,root.right,s);
        return ret;
    }
    
    private void helper(List<String> ret, TreeNode root, String s){
        if(root.left == null && root.right == null){
            ret.add(s+"->"+root.val);
            return;
        }
        if(root.left != null) helper(ret,root.left,s+"->"+root.val);
        if(root.right != null) helper(ret,root.right,s+"->"+root.val);
    }
}

