/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode ret = new ListNode(Integer.MIN_VALUE);
        while(head != null){
            ListNode tmp = ret;
            while(tmp != null){
                if(tmp.next == null){
                    ListNode tmp2 = head;
                    head = head.next;
                    tmp.next = tmp2;
                    tmp2.next = null;
                    break;
                }
                if(tmp.next.val > head.val){
                    ListNode tmp2 = tmp.next;
                    ListNode tmp3 = head;
                    head = head.next;
                    tmp.next = tmp3;
                    tmp3.next = tmp2;
                    break;
                }
                tmp = tmp.next;
            }
        }
        return ret.next;
    }
}
