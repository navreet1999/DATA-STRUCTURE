/*
There are two singly linked lists of size N and M in a system. But, due to some programming error the end node of one of the linked list got linked into one of the node of second list, forming a inverted Y shaped list. Write a program to get the point where two linked lists intersect each other.

Y ShapedLinked List
Above diagram shows an example with two linked list having 15 as intersection point.
Note: Expected time complexity is O(m + n) where m and n are lengths of two linked lists.

Input:
First line of input is the number of test cases T. Every test case has four lines. First line of every test case contains three numbers, x (number of nodes before merge point in 1st list), y (number of nodes before merge point in 11nd list) and z (number of nodes after merge point). Next three lines contain x, y and z values.

Output:
Print the data of the node in the linked list where two linked lists intersects.

Your Task:
The task is to complete the function intersetPoint() which finds the point of intersection of two linked list. The function should return data value of a node where two linked lists merge. If linked list do not merge at any point, then it shoudl return -1.

Constraints:
1 <= T <= 50
1 <= N <= 100
1 <= value <= 1000

Example:
Input:
2
2 3 2
10 20
30 40 50
5 10
2 3 2
10 20
30 40 50
10 20

Output:
5
10*/

    import java.util.*;


    class Node
    {
        int data;
        Node next;
        Node(int d) {
            data = d; 
            next = null;
        }
    }
        
     class LinkedList_Intersection
    {
        Node head = null;  
        Node tail = null;
    
    public void addToTheLast(Node node) 
    {
    
      if (head == null) {
       head = node;
       tail = head;
      } else {
       //Node temp = head;
       //while (temp.next != null)
        //temp = temp.next;
    
       //temp.next = node;
       tail.next=node;
       tail = node;
      }
    }
    
      /* Function to print linked list */
        void printList()
        {
            Node temp = head;
            while (temp != null)
            {
               System.out.print(temp.data+" ");
               temp = temp.next;
            }  
            System.out.println();
        }
        
         
     
         /* Driver program to test above functions */
        public static void main(String args[])
        {
           
             
            /* Constructed Linked List is 1->2->3->4->5->6->
               7->8->8->9->null */
             Scanner sc = new Scanner(System.in);
             int t=sc.nextInt();
             
             while(t>0)
             {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                int n3 = sc.nextInt();
                LinkedList_Intersection llist1 = new LinkedList_Intersection();
                LinkedList_Intersection llist2 = new LinkedList_Intersection();
                LinkedList_Intersection llist3 = new LinkedList_Intersection();
                
                    int a1=sc.nextInt();
                    Node head1= new Node(a1);
                    Node tail1= head1;
                    llist1.addToTheLast(head1);
                    for (int i = 1; i < n1; i++) 
                    {
                        int a = sc.nextInt(); 
                        llist1.addToTheLast(new Node(a));
                    }
                
                
                    int b1=sc.nextInt();
                    Node head2 = new Node(b1);
                    Node tail2 = head2;
                    llist2.addToTheLast(head2);
                    for (int i = 1; i < n2; i++) 
                    {
                        int b = sc.nextInt(); 
                        llist2.addToTheLast(new Node(b));
                    }
                    
                    int c1=sc.nextInt();
                    Node head3= new Node(c1);
                    Node tail3=head3;
                    llist3.addToTheLast(head3);
                    for (int i = 1; i < n3; i++) 
                    {
                        int c = sc.nextInt(); 
                        llist3.addToTheLast(new Node(c));
                    }
                    
                    if (tail1 != null)
                    tail1.next = head3;
                    if (tail2 != null)
                    tail2.next = head3;
                    
                    Intersect obj = new Intersect();
                    System.out.println(obj.intersectPoint(llist1.head, llist2.head));
                t--;			
             }
        }
    }
    
    // } Driver Code Ends
    /* Node of a linked list
     class Node {
       int data;
        Node next;
        Node(int d)  { data = d;  next = null; }
    }
     Linked List class
    class LinkedList
    {
        Node head;  // head of list
    }
    This is method only submission.  You only need to complete the method. */
    class Intersect
    {
        int intersectPoint(Node headA, Node headB)
        {
             HashSet<Node> hs=new HashSet<Node>();
             while(headA!=null)
             {
                 hs.add(headA);
                 headA=headA.next;
             }
             
             while(headB!=null)
             {
                 if(hs.contains(headB))
                 return headB.data;
                 
                 headB=headB.next;
             }
             return 0;
        }
    }
    
    
    