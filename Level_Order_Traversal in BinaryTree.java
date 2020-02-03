/*
You are given a tree and you need to do the level order traversal on this tree.
Level order traversal of a tree is breadth-first traversal for the tree.



Level order traversal of above tree is 1 2 3 4 5*/
// { Driver Code Starts



import java.util.*;
import java.io.*;
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
class GfG{
    
    public static void main(String[] args)throws IOException{
        //Scanner sc=new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t=Integer.parseInt(br.readLine());
       
        while(t > 0){
            Queue<Node> q = new LinkedList<>();
        
            int n = Integer.parseInt(br.readLine());
            String input[] = br.readLine().trim().split(" ");
            
            Node root = null;
            int j=0;
            while(n > 0){
            int a1 = Integer.parseInt(input[j]);
            int a2 = Integer.parseInt(input[j+1]);
            char lr = input[j+2].charAt(0);
            j+=3;
            
            if(root == null)
            {
                root = new Node(a1);
                q.add(root);
            }
            
            Node pick = q.peek();
            
            q.remove();
            
            if(lr=='L'){
                pick.left = new Node(a2);
                q.add(pick.left);
            }
            a1 = Integer.parseInt(input[j]);
            a2 = Integer.parseInt(input[j+1]);
            lr = input[j+2].charAt(0);
            j += 3;
            
            if(lr=='R'){
                pick.right = new Node(a2);
                q.add(pick.right);
            }
            
            n-=2;
        }
            Level_order_traversal g = new Level_order_traversal();
            g.levelOrder(root);
			System.out.println();
            t--;
            
        }
    }
   
}
// } Driver Code Ends
//User function Template for Java



/*
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Level_order_traversal
{
    //You are required to complete this method
    static void levelOrder(Node root) 
    {
        // Your code here
        Queue<Node> q=new LinkedList<Node>();
        q.add(root);
        
        while(!q.isEmpty())
        {
            Node tempnode=q.poll();
            System.out.print(tempnode.data+" ");
            
            if(tempnode.left!=null)
            q.add(tempnode.left);
            if(tempnode.right!=null)
            q.add(tempnode.right);
        }
        
        
    }
}





