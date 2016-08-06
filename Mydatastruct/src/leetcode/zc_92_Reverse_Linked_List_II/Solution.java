/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        if(m==n) return head;
        dummy.next = head;
        ListNode start = dummy;
        while(--m != 0){
            start = start.next;
        }
        ListNode end = dummy;
        while(n-- != 0){
            end = end.next;
        }
        // System.out.println(start.val);
        // System.out.println(end.val);
        ListNode tmp = start;
        ListNode tmp1 = start.next;
        ListNode tmp2 =tmp1.next;
        while( tmp2 != end){
            tmp1.next = tmp;
            tmp = tmp1;
            tmp1 =tmp2;
            tmp2 = tmp2.next;
        }
        // System.out.println("pass1");
        start.next.next = end.next;
        start.next = end;
        end.next = tmp1;
        if(tmp!=start) tmp1.next = tmp;
        // System.out.println("pass2");
        return dummy.next;
        
    }
}
