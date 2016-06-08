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
    ListNode* deleteDuplicates(ListNode* head) {
        if(!head)
            return NULL;
        ListNode *tmp = head;
        while(tmp->next){
            if(tmp->next->val==tmp->val){
                ListNode * deltmp = tmp->next;
                tmp->next = deltmp->next;
                delete deltmp;
                continue;
            }
            tmp = tmp->next;
            if(!tmp)
                break;
        }
        return head;
    }
};