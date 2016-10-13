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
    private Stack<TreeNode> l2r = new Stack<TreeNode>();
    private Stack<TreeNode> r2l = new Stack<TreeNode>();
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> ret = new ArrayList<>();
        if(root == null ) return ret;
        l2r.add(root);
        while(!l2r.empty() || !r2l.empty()){
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            if(!l2r.empty())
                while(!l2r.empty()){
                    TreeNode n = l2r.pop();
                    tmp.add(n.val);
                    if(n.left != null) r2l.push(n.left);
                    if(n.right != null) r2l.push(n.right);

                }
            else
                while(!r2l.empty()){
                    TreeNode n = r2l.pop();
                    tmp.add(n.val);
                    if(n.right != null) l2r.push(n.right);
                    if(n.left != null) l2r.push(n.left);
                }
            ret.add(tmp);
        }
        return ret;
    }
}
