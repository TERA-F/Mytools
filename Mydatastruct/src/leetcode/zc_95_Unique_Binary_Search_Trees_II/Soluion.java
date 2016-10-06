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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] list = new List[n+1];
        list[0] = new ArrayList<TreeNode>();
        if(n==0) return list[0];
        list[0].add(null);
        for(int len = 1; len < n+1 ; len++){
            list[len] = new ArrayList<TreeNode>();
            for(int j = 0 ; j < len ; j++)
                for(TreeNode left : list[j])
                    for(TreeNode right : list[len-1-j]){
                        TreeNode node = new TreeNode(j+1);
                        node.left = left;
                        node.right = clone(right,j+1);
                        list[len].add(node);
                    }
        }
        return list[n];
    }
    
    private TreeNode clone(TreeNode right, int i){
        if(right == null) return null;
        TreeNode tmp = new TreeNode(right.val+i);
        tmp.left = clone(right.left,i);
        tmp.right = clone(right.right,i);
        return tmp;
    }
}
