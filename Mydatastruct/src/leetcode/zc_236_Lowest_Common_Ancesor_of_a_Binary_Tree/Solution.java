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
/*    private List<TreeNode> pl;
    private List<TreeNode> ql;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;
        helper(root,q,new ArrayList<TreeNode>());
        ql = pl;
        helper(root,p,new ArrayList<TreeNode>());
        int n = Math.min(pl.size(),ql.size());
        for(int i = 1 ; i < n ; i++){
            if(pl.get(i)!=ql.get(i)) return pl.get(i-1);
        }
        return pl.size()>ql.size() ? ql.get(ql.size()-1):pl.get(pl.size()-1);
        
    }
    
    private void helper(TreeNode root, TreeNode p, List<TreeNode> pl){
        if(root == null) return;
        if(root != null){
            if(root == p){
                pl = new ArrayList<TreeNode>(pl);
                pl.add(root);
            }else{
                List<TreeNode> tmp = new ArrayList<TreeNode>(pl);
                tmp.add(root);
                helper(root.left,p,tmp);
                helper(root.right,p,tmp);
            }
        }
        
    }*/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        parent.put(root, null);
        stack.push(root);

        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        while (!ancestors.contains(q))
            q = parent.get(q);
        return q;
    }
}
