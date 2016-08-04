/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        int countA = 0;
        int countB = 0;
        ListNode p = headA;
        ListNode q = headB;
        while(p != null){
            p = p.next;
            ++countA;
        }
        while(q != null){
            q = q.next;
            ++countB;
        }
        p = headA;
        q = headB;
        if(countA > countB){
            int tmp = countA - countB;
            while( tmp-- > 0) p = p.next;
        }else{
            int tmp = countB - countA;
            while( tmp-- > 0) q = q.next;
        }
        while(p != null && q != null){
            if(p == q) return p;
            p = p.next;
            q = q.next;
        }
        return null;
    }
}
