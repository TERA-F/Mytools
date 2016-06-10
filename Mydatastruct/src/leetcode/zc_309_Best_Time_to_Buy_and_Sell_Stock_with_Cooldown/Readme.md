之前想的很复杂，后来看到讨论的结果其实比较简单，主要就是状态转移的过程怎么判断，把第i天可能做的判断分成4中情况，然后根据4中情况中i-1天的条件写递归条件，从第0天迭代到最后一天判断哪个大就可以了。


before I see the discuss, I think it is really hard question. But solution of discuss is really simple. the key is find the process of state transition. I need divide possible behavior  to 4 situations.  Has or not has stock and sell it or not. Then you need set 1st day sell, by iterator algorithm I will find result at last day.