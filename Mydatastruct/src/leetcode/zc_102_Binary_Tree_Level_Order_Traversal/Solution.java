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
    
    private Deque<TreeNode> layer = new ArrayDeque<TreeNode>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> ret = new ArrayList<>();
        if(root == null ) return ret;
        layer.add(root);
/*        ArrayList<Integer> rootval = new ArrayList<Integer>();
        rootval.add(root.val);
        ret.add(rootval);*/
        while(!layer.isEmpty()){
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            int len = layer.size();
            for(int i = 0 ; i < len;i++){
                TreeNode n = layer.remove();
                if(n.left!=null)
                    layer.add(n.left);
                if(n.right!=null)
                    layer.add(n.right);
                tmp.add(n.val);
            }
            ret.add(tmp);
        }
        return ret;
    }
}
