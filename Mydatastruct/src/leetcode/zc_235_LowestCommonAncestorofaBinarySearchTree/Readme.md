这个迭代的方式利用了二叉树的特点。父节点的值介于左右两个节点的值之间，如果两个节点之间有共同的父节点则这个父节点必定把这两个节点的值均分。
我之前的想法是利用两个队列找到两个树。然后根据这两对列找到最后一个相同的节点即为所属父节点。

This iterative approach take advantage of the characteristics of a binary search tree.namely, The value of the parent node must be between the value of left child node and right child node. If there is a Lowest Common ancestor of two nodes, two difference, ancestor's value and node P's value, ancestor's value and node P's value must have different sign.

befor that, I try to use queue to track	the path of the node from root node.but I use it in  wrong way, but I still think it works.