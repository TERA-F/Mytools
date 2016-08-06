/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode ret = new ListNode(0);
        ret.next = head;
        ListNode retu = ret;
        while(ret.next != null){
            if(ret.next.val == val){
                if(ret.next.next != null){
                    ListNode tmp = ret.next;
                    ret.next = tmp.next;
                    continue;
                }else{
                    ret.next = null;
                    return retu.next;
                }
            }
            ret = ret.next;
        }
        return retu.next;
    }
}
