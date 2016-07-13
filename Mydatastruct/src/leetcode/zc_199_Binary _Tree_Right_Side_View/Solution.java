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
    vector<int> rightSideView(TreeNode* root) {
        vector<int> ret;
        helper(ret,root,1);
        return ret;
    }
    
    void helper(vector<int> & ret, TreeNode * tmp,int depth){
        if(!tmp)
            return;
        if(depth>ret.size())
            ret.push_back(tmp->val);
        else{
            ret[depth-1] = tmp->val;
        }
        helper(ret,tmp->left,depth+1);
        helper(ret,tmp->right,depth+1);
    }
};