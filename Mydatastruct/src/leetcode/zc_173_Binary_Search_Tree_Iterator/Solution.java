/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    Stack<TreeNode> sta = new Stack<TreeNode>();
    TreeNode n;
    public BSTIterator(TreeNode root) {
        while(root != null){
            sta.push(root);
            root = root.left;
        }
/*        n = sta.pop();
        TreeNode tmp;
        if(n.right != null){
            tmp = n.right;
            while(tmp != null){
                sta.push(tmp);
                tmp = tmp.left;
            }
        }*/
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(sta.empty())
            return false;
        else{
            n = sta.pop();
            TreeNode tmp;
            if(n.right != null){
                tmp = n.right;
                while(tmp != null){
                    sta.push(tmp);
                    tmp = tmp.left;
                }
            }
            return true;
        }
        
    }

    /** @return the next smallest number */
    public int next() {
        return n.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
