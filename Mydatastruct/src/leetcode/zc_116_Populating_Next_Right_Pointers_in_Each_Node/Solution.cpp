/**
 * Definition for binary tree with next pointer.
 * struct TreeLinkNode {
 *  int val;
 *  TreeLinkNode *left, *right, *next;
 *  TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
 * };
 */
class Solution {
public:
    void connect(TreeLinkNode *root) {
        helper(root,NULL);
    }
    
    void helper(TreeLinkNode * lefttmp,TreeLinkNode * righttmp){
        if(!lefttmp)
            return ;
        
        lefttmp->next = righttmp;
        helper(lefttmp->left,lefttmp->right);
        if(!righttmp){
            helper(lefttmp->right,NULL);
            return ;
        }
        helper(lefttmp->right,righttmp->left);
        helper(righttmp->left,righttmp->right);
    }
};