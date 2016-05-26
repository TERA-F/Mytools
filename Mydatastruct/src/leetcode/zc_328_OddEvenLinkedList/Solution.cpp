/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* oddEvenList(ListNode* head) {
        if(!(head && head->next))
            return head;
        ListNode * odd=head;
        ListNode * even=head->next;
        
        ListNode * second = head->next;

        
        while(true)
        {
            if(even->next){
                odd->next = even->next;
                odd = odd->next;
            }else
                break;
                
            if(odd->next){
                even->next = odd->next;
                even = even->next;
            }else
                break;
        }

        odd->next = second;

        even->next = NULL;

        return head;
    }
};