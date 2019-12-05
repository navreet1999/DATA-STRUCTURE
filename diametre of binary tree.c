/*
Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
*/

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

int height(struct TreeNode * root)
{
    if(root==NULL)
        return NULL;
    else
    {
       int  l=height(root->left);
       int  r=height(root->right);
        
        if(l>r)
            return l+1;
        else
            return r+1;
    }
}
int max(int a,int b)
{
    return a>b?a:b;
}
int diameterOfBinaryTree(struct TreeNode* root)
{
    if(root==NULL)
        return NULL;
     
    int lheight=height(root->left);
    int rheight=height(root->right);
    
    int ldia=diameterOfBinaryTree(root->left);
    int rdia=diameterOfBinaryTree(root->right);
    
    return max((lheight+rheight),max(ldia,rdia));
    
}


