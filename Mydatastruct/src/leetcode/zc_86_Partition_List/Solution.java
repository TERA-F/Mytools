/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode big = new ListNode(0);
        ListNode b = big;
        ListNode s = small;
        if(head == null) return null;
        while(head != null){
            if(head.val >= x){
                b.next = head;
                head = head.next;
                b = b.next;
                b.next = null;
            }else{
                s.next = head;
                head = head.next;
                s = s.next;
                s.next = null;
            }
        }
        s.next = big.next;
        return small.next;
    }
}
