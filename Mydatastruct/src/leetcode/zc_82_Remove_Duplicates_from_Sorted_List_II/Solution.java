/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ret = head;
        if(ret == null  || ret.next == null) return head;
        HashSet<Integer> rmnum = new HashSet<Integer>();
        while(ret.next !=null){
            if(ret.val == ret.next.val){
                ret.next =ret.next.next;
                rmnum.add(ret.val);
            }else{
                ret = ret.next;
            }
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ret = dummy;
        while(ret.next != null){
            if(rmnum.contains(ret.next.val))
                ret.next = ret.next.next;
            else
                ret = ret.next;
        }
        return dummy.next;
    }
}
