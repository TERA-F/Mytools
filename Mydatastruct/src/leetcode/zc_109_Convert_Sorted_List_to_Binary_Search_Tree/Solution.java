/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
/*    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        ListNode head2 = head;
        int count = 0;
        if(head==null) return null;
        while(head2 != null){
            list.add(new TreeNode(head2.val));
            head2 = head2.next;
            count++;
        }
        return helper(list,0,count-1);
    }
    
    private TreeNode helper(ArrayList<TreeNode> list , int i , int j){
        if(i >= j ) return list.get(i);
        if( j - i == 1 ){
            list.get(i).right = list.get(j);
            return list.get(i);
        }
        int mid = (i + j)/2;
            
        list.get(mid).left = helper(list,i,mid-1);
        list.get(mid).right = helper(list,mid+1,j);
        
        return list.get(mid);
    }*/
    
    private ListNode node;
    
    public TreeNode sortedListToBST(ListNode head) {
    	if(head == null){
    		return null;
    	}
    	
    	int size = 0;
    	ListNode runner = head;
    	node = head;
    	
    	while(runner != null){
    		runner = runner.next;
    		size ++;
    	}
    	
    	return inorderHelper(0, size - 1);
    }
    
    public TreeNode inorderHelper(int start, int end){
    	if(start > end){
    		return null;
    	}
    	
    	int mid = start + (end - start) / 2;
    	TreeNode left = inorderHelper(start, mid - 1);
    	
    	TreeNode treenode = new TreeNode(node.val);
    	treenode.left = left;
    	node = node.next;
    
    	TreeNode right = inorderHelper(mid + 1, end);
    	treenode.right = right;
    	
    	return treenode;
    }
}
