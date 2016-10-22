/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> sta = new Stack<TreeNode>();
        TreeNode node = root;
        while(!sta.isEmpty() || node!=null){
            if(node != null){
                sb.append(String.valueOf(node.val)+" ");
                sta.push(node);
                node = node.left;
            }else{
                sb.append("null ");
                node = sta.pop();
                node = node.right;
            }
        }
        System.out.println(sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        String [] list = data.split(" ");
        int n = list.length;
        TreeNode root = new TreeNode(Integer.parseInt(list[0]));
        TreeNode tmp = root;
        Stack<TreeNode> sta = new Stack<TreeNode>();
        sta.push(tmp);
        int i = 1;
        while(i < n){
            while(i<n && !list[i].equals("null")){
                tmp.left = new TreeNode(Integer.parseInt(list[i++]));
                tmp = tmp.left;
                sta.push(tmp);
            }
            while(i<n && list[i].equals("null")){
                tmp = sta.pop();
                i++;
            }
            if(i<n){
                tmp.right = new TreeNode(Integer.parseInt(list[i++]));
                tmp = tmp.right;
                sta.push(tmp);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
