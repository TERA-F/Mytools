/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode p = new ListNode(0);
        p.next = head;
        ListNode retnext = p;
        while(p.next != null && p.next.next != null){
            ListNode tmp1 = p.next;
            ListNode tmp2 = p.next.next;
            ListNode tmp3 = p.next.next.next;
            p.next = tmp2;
            tmp1.next = tmp3;
            tmp2.next = tmp1;
            p = tmp1;
        }
        return retnext.next;
    }
}
