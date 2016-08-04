/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        int count = 0;
        ListNode p = head;
        while(p != null){
            p = p.next;
            ++count;
        }
        System.out.println(count);
        p = head;
        count = count - n + 1;
        if(count <= 1) return head.next;
        while(p != null){
            if(--count == 1){
                if(p.next != null){
                    p.next = p.next.next;
                }else{
                    p.next = null;
                }
                break;
            }
            p = p.next;
        }
        return head;
    }
}
