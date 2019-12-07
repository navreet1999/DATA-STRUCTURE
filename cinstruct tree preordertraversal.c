/*
Construct Binary Tree From Inorder And Preorder
Asked in:  
Amazon
Microsoft
Given preorder and inorder traversal of a tree, construct the binary tree.

 Note: You may assume that duplicates do not exist in the tree. 
Example :

Input :
        Preorder : [1, 2, 3]
        Inorder  : [2, 1, 3]

Return :
            1
           / \
          2   3
*/



 treenode * newNode(int value)
 {
     treenode * newnode=(treenode *)malloc(sizeof(treenode));
     newnode->val=value;
     newnode->left=NULL;
     newnode->right=NULL;
     return newnode;
 }
 treenode *construct(int *A,int *B,int start,int end,int *pre)
 {
     if(start>end)
     return NULL;
     treenode *node=newNode(A[(*pre)++]);
     
     int i;
     for(i=start;i<end;i++)
     {
         if(B[i]==node->val)
         break;
     }
     
     node->left=construct(A,B,start,i-1,pre);
     node->right=construct(A,B,i+1,end,pre);
     return node;
 }
 
treenode* buildTree(int* A, int n1, int* B, int n2) {
   int *pre=0;
   return construct(A,B,0,n2-1,&pre);

}

