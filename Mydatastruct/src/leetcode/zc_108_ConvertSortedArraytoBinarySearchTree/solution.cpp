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
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        if(nums.size()==0)
            return NULL;
        vector<TreeNode*> retval;
        for(int i : nums)
            retval.push_back(new TreeNode(i));
        //vector<TreeNode*>::iterator itr;
        //itr = retval.begin();
        //cout<<*itr;
        return helper(retval,0,retval.size()-1);
    }
    
    TreeNode * helper( vector<TreeNode*> & retval , int start, int end){
        if(start == end)
            return retval[start];
        if((end - start)==1)
        {
            retval[end]->left = retval[start];
            return retval[end];
        }
        int mid;
        if((end - start)%2)
            mid = (start + end) /2 + 1;
        else
            mid = (start + end) /2;
        retval[mid]->left = helper(retval,start,mid-1);
        retval[mid]->right = helper(retval,mid+1,end);
        return retval[mid];
    }
};