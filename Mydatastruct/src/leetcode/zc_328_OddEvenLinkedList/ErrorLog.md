1.������һ��expected unqualified-id before return in c++����
��Ҫ����Ϊ��д��һ������

2.����ж������Ƿ�ĩβ
ʹ��if(head->next)������ʹ��head->next!=NULL��������������

3.����һ��time out����
��Ҫ����odd->next = second ��ʹ����odd->next = head->next.��������֮ǰ�Ķ���head->next.���Է�����һ����β���������������³�ʱ��

1.I get a error:expected unqualified-id before return.
cause I forgot a brace before return.

2.how to determine if the program is reach end of ListNode?
I should use if(head->next) instead of if(head->next!=NULL), or you will get error.

3.I get a time out Limit error
Cause I use odd->next = head->next, but I change head->next, so the program return a chain of ListNode.
Then I change this line to odd->next = second and solve it;