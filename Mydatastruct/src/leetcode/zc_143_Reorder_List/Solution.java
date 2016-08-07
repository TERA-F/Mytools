/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next ==  null || head.next.next == null ) return ;
        ListNode dum = new ListNode(0);
        ListNode l1 = head;
        ListNode l2 = head;
        int count = 0;
        while(l1.next != null && l1.next.next != null){
            l1 = l1.next.next;
            l2 = l2.next;
        }
        ListNode tmp1 = l2;
        ListNode tmp2 = l2.next;
        ListNode tmp3 = l2.next.next;
        while(tmp3 != null){
            tmp2.next = tmp1;
            tmp1 = tmp2;
            tmp2 = tmp3;
            tmp3 = tmp3.next;
        }
        tmp2.next = tmp1;
        l2.next.next = null;
        l2.next = null;
        l1 = head;
        l2 = tmp2;
        while(l1.next != null && l2.next != null){
            tmp1 = l1.next;
            tmp2 = l2.next;
            l1.next = l2;
            l2.next = tmp1;
            l1 = tmp1;
            l2 = tmp2;
        }
        if(l1.next == null) l1.next = l2;
        else{
            tmp1 = l1.next;
            l1.next =l2;
            l2.next =tmp1;
        }
        
    }
}
