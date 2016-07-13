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
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> result;
        stack<TreeNode *> staTN;
        TreeNode * tmp = root;
        while( !staTN.empty() || tmp!=NULL)
        {
            while(tmp!=NULL)
            {
                staTN.push(tmp);
                tmp=tmp->left;
            }
            //tmp = staTN.pop();有可能返回空值
            tmp = staTN.top();
            result.push_back(tmp->val);
            staTN.pop();
            tmp=tmp->right;
        }
        return result;
    }
};