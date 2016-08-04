/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode [] kNode = new ListNode[k+2];
        ListNode retnext  = new ListNode(0);
        retnext.next = head;
        ListNode p = retnext;
        if( k<=1 ) return retnext.next;
        while(p!=null){
            kNode[0] = p;
            for(int i = 1 ; i < k+1 ; ++i){
                if(p.next != null){
                    kNode[i] = p.next;
                    p = p.next;
                }else
                    return retnext.next;
            }
            kNode[k+1] = p.next;
            kNode[0].next = kNode[k];
            kNode[1].next = kNode[k+1];
            for(int i = 2 ; i < k+1 ; ++i){
                kNode[i].next = kNode[i-1];
            }
            p = kNode[1];
        }
        return retnext.next;
    }
}
