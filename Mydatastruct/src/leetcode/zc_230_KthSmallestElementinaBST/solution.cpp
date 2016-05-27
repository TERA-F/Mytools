/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int kthSmallest(TreeNode* root, int k) {
        if( root == NULL |k == 0)
            return NULL;
        stack<TreeNode*> sta;
        int nowK = 0;
        TreeNode * tmp = root;
        sta.push(root);
        
        while(!sta.empty()|tmp==NULL){
            while(tmp!=NULL){

                sta.push(tmp);
                tmp = tmp->left;
            }
            tmp = sta.top();
            sta.pop();
            if(tmp!=NULL){
                nowK++;
                if(nowK==k)
                    return tmp->val;
                tmp = tmp->right;
            }
        }
        return 0;
    }
};