a/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int target;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        target = sum;
        List<List<Integer>> ret = new ArrayList();
        if(root == null) return ret;
        List<Integer> tmp = new ArrayList<Integer>();
        tmp.add(root.val);
        if(root.left == null && root.right == null){
            if(root.val ==sum)
                ret.add(tmp);
            return ret;
        }
        helper(ret,new ArrayList<Integer>(tmp),root.left,root.val);
        helper(ret,new ArrayList<Integer>(tmp),root.right,root.val);
        return ret;
    }
    
    private void helper(List<List<Integer>> ret, List<Integer> tmp, TreeNode node,int val){
        if(node == null) return;
        tmp.add(node.val);
        if(node.left == null && node. right == null){
            if(node.val+val == target){
                ret.add(tmp);
                return;
            }
        }
        helper(ret,new ArrayList<Integer>(tmp),node.left,val+node.val);
        helper(ret,new ArrayList<Integer>(tmp),node.right,val+node.val);
    }
}
