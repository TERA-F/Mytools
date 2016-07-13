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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ReList = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root != null) stack.push(root);
        while(!stack.isEmpty())
        {
            TreeNode tmp = stack.pop();
            ReList.add(tmp.val);
            if(tmp.right!=null) stack.push(tmp.right);
            if(tmp.left!=null) stack.push(tmp.left);
        }
        return ReList;
    }
}