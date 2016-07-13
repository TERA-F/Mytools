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
    ListNode* reverseList(ListNode* head) {
        /*
        if(head==NULL)
            return NULL;
        stack<ListNode> Sta;
        ListNode * tmp=head;
        while(tmp!=NULL)
        {
            tmp = tmp->next;
            Sta.push(*tmp);
        }
        ListNode * tmp2 = & Sta.top();
        Sta.pop();
        while(!Sta.empty())
        {
            tmp2->next = & Sta.top();
            Sta.pop();
            tmp2=tmp2->next;
        }
        return tmp2;
        */
        if(head==NULL)
            return NULL;
        if(head->next==NULL)
            return head;
        ListNode * tmp1 = head;
        ListNode * tmp2 = head->next;
        ListNode * tmp;
        tmp1->next = NULL;
        while(tmp2!=NULL)
        {
            tmp=tmp2->next;
            tmp2->next=tmp1;
            tmp1=tmp2;
            tmp2=tmp;
            //cout<<tmp1->val;
        }
        
        return tmp1;
    }
};