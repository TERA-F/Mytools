1.遇到了一个expected unqualified-id before return in c++错误
主要是因为少写了一个括号

2.如何判断链表是否到末尾
使用if(head->next)而不是使用head->next!=NULL。否则会产生错误。

3.返回一个time out错误
主要是在odd->next = second 中使用了odd->next = head->next.但是由于之前改动过head->next.所以返回了一个首尾相连的链表环，导致超时。

1.I get a error:expected unqualified-id before return.
cause I forgot a brace before return.

2.how to determine if the program is reach end of ListNode?
I should use if(head->next) instead of if(head->next!=NULL), or you will get error.

3.I get a time out Limit error
Cause I use odd->next = head->next, but I change head->next, so the program return a chain of ListNode.
Then I change this line to odd->next = second and solve it;