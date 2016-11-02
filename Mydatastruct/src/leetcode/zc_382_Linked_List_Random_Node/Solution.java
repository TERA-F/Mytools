/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    private ListNode head;

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
/*        Random rand = new Random();
        int count =1;
        ListNode tmp = h;
        while(tmp != null){
            if(rand.nextInt(count++)==1){
                return tmp.val;
            }
            tmp = tmp.next;
        }
        return h.val;*/
        Random rand = new Random();
        int val = head.val;
        ListNode cur = head;
        int count = 1;
        
        while ((cur = cur.next) != null)
        {
            if (rand.nextInt(++count) == 0)
                val = cur.val;
        }
        
        return val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
