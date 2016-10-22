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
    public void flatten(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> sta = new Stack<TreeNode>();
        TreeNode tmp = root;
        while(!sta.isEmpty() || tmp.right !=null || tmp.left !=null){
            if(tmp.left == null){
                if(tmp.right == null)
                    tmp.right = sta.pop();
                
            }else{
                if(tmp.right != null)
                    sta.push(tmp.right);
                tmp.right = tmp.left;
                tmp.left =null;
            }
            System.out.println(tmp.val);
            tmp = tmp.right;
        }
    }
}
