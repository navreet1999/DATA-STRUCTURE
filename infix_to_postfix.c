/*

Given string A denoting an infix expression. Convert the infix expression into postfix expression.

String A consists of ^, /, *, +, -, (, ) and lowercase english alphabets.

where lowercase english alphabets are operands and ^, /, *, +, - are operators.

Find and return the postfix expression of A.

Note: 

^ has highest precedence.
/ and *** have equal precedence but greater than **+ and -.
+ and - have equal precedence and lowest precedence among given operators.


Input Format

The only argument given is string A.
Output Format


Return the postfix conversion of A.
Constraints

1 <= length of the string <= 500000
-10^9 <= A[i] <= 10^9 
For Example

Input 1:
    A = "x^y/(a*z)+b"
Output 1:
    "xy^az* /b+"

Input 2:
    A = "a+b*(c^d-e)^(f+g*h)-i"
Output 2:
    "abcd^e-fgh*+^*+i-"
    
    
    */



 
typedef struct sNode
 {
     char data;
     struct sNode* next;
 }stack;
 stack* s=NULL;
 void push(char new_data)
{
  stack* new_node = (stack*) malloc(sizeof(stack));
  new_node->data  = new_data;
  new_node->next = s;
  s=new_node;
}
int pop()
{
  stack *temp;
   int t;
   temp=s;
   t=temp->data;
   s=s->next;
   temp->next=NULL;
   free(temp);
     return t;
}
int isEmpty()
{
    if(s==NULL)
    return 1;
    else
    return 0;
}
int peek()
{
    if(s==NULL)
    return 0;
    else
    return s->data;
}
int Prec(char ch)
{
    switch (ch)
    {
    case '+':
    case '-':
        return 1;

    case '*':
    case '/':
        return 2;

    case '^':
        return 3;
    }
    return -1;
}
int isOperand(char ch)
{
    return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
}
char* solve(char* exp) 
{
   
    int i,k;
for (i = 0, k = -1; exp[i]; ++i)
    {
        if (isOperand(exp[i]))
            exp[++k] = exp[i];
        else if (exp[i] == '(')
            push(exp[i]);
        else if (exp[i] == ')')
        {
            while (!isEmpty() && peek() != '(')
                exp[++k] = pop();
            if (!isEmpty() && peek() != '(')
                return -1; 
            else
                pop();
        }
        else
        {
            while (!isEmpty() && Prec(exp[i]) <= Prec(peek()))
                exp[++k] = pop();
            push(exp[i]);
        }

    }
    while (!isEmpty())
        exp[++k] = pop();

    exp[++k] = '\0';
   
    return exp;
}
