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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList();
        if(root == null) return ret;
        helper(ret,root,1);
        Collections.reverse(ret);
        return ret;
    }
    
    private void helper(List<List<Integer>> ret, TreeNode root,int dep){
        if(ret.size()<dep){
            List<Integer> tmp = new ArrayList<Integer>();
            ret.add(tmp);
        }
        if(root==null) return;
        List<Integer> tmp = ret.get(dep-1);
        tmp.add(root.val);
        if(root.left!=null) helper(ret,root.left,dep+1);
        if(root.right!=null) helper(ret,root.right,dep+1);
    }
}
