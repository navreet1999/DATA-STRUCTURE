
 /*
 Given a binary tree of integers. Find the difference between
the sum of nodes at odd level and sum of nodes at even level.

Note: Consider the level of root node as 1.

Constraints

1 <= Number of nodes in binary tree <= 100000
0 <= node values <= 10^9 
For Example

Input 1:
            1
          /   \
         2    3
        / \  / \
       4   5 6  7
      /
     8 
Output 1:
    10
    Sum of nodes at odd level = 23
    Sum of ndoes at even level = 13

Input 2:
            1
           /  \
          2    10
           \
            4
Output 2:
    -7
    Sum of nodes at odd level = 5
    Sum of ndoes at even level = 12*/
    
    
    
    typedef struct link
{
  struct treenode* node;
  struct link *next;
}link;
typedef struct queue
{
  struct link* front;
  struct link* rear;
}queue;
void push(queue **q,treenode* n)
{
  struct link* new=(struct link*)malloc(sizeof(struct link));
  new->node=n;
  new->next=NULL;
  if((*q)->rear==NULL)
  {
   (*q)->front=new;
    (*q)->rear=new;
  }
  else
  {
    ((*q)->rear)->next=new;
    (*q)->rear=new;
  }
}
void pop(struct queue **q)
{
  if((*q)->front==NULL)
    return;
  if((*q)->front==(*q)->rear)
  {
    (*q)->front=(*q)->rear=NULL;
    return;
  }
  else
  {
    (*q)->front=((*q)->front)->next;
  }
}
struct treenode* top(struct queue *q)
{
  if(q->front==NULL)
  {
    return NULL;
  }
  return q->front->node;
}
int empty(struct queue *q)
{
  return q->front==NULL;
}

int solve(treenode* root) 
{ 
    if (!root) 
        return 0; 


  queue *q=(struct queue*)malloc(sizeof(queue));
  q->front=NULL;
  q->rear=NULL;
  push(&q,root);

    int level = 0; 
    int evenSum = 0, oddSum = 0; 

  int k=1,t=0;
    while (!empty(q)) 
    { 
    
        level += 1; 
t=k;
      k=0;
        
        while(!empty(q)&& t!=0) 
        { 
            treenode* temp = top(q); 
            pop(&q); 

            
            if(level % 2 == 0) 
                evenSum += temp->val; 
            else
                oddSum += temp->val; 
        
            // check for left child 
            if (temp->left) 
            { k++;
                push(&q,temp->left);
            } 
            
            // check for right child 
            if (temp->right) 
            { k++;
               push(&q,temp->right);
            } 
            t--; 
        } 
    } 
    
    return (oddSum - evenSum); 
} 


