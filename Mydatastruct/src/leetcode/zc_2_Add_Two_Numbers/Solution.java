/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(1);
        dummy1.next = l1;
        dummy2.next = l2;
        int step = 0;
        while(dummy1.next != null && dummy2.next != null){
            dummy2.next.val = dummy1.next.val+dummy2.next.val+step;
            step = dummy2.next.val/10;
            if(step==1) dummy2.next.val -= 10;
            dummy1 = dummy1.next;
            dummy2 = dummy2.next;
        }
        if(dummy1.next != null) dummy2.next = dummy1.next;
        while(dummy2.next != null){
            dummy2.next.val += step;
            step = dummy2.next.val/10;
            if(step == 1) dummy2.next.val -= 10;
            dummy2 = dummy2.next;
        }
        if(step==1) dummy2.next = new ListNode(1);
        return l2;
    }
}
