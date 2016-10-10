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
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> ret = new LinkedList<Integer>();
        Deque<TreeNode> que = new ArrayDeque();
        TreeNode tmp = root;
        while(!(que.isEmpty())||tmp!=null){
            if(tmp!=null){
                que.push(tmp);
                ret.addFirst(tmp.val);
                tmp = tmp.right;
            }else{
                tmp = que.pop();
                tmp = tmp.left;
            }
        }
        return ret;
    }
}
