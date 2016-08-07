/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null || head.next == null) return head;
        ListNode p1 = head;
        ListNode pre = head ;
        int count = 0;
        while( p1 != null){
            pre = p1;
            p1 = p1.next;
            count++;
        }
        k %= count;
        pre.next = head;
        count = count - k;
        
        p1 = head;
        ListNode p2 = head.next;
        
        while(--count != 0){
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = null;
        return p2;
        
    }
}
