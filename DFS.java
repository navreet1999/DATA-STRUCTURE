/*
Given N nodes and E edges of a graph. The task is to do depth first traversal of the graph.

Note: Use recursive approach.

Input:
First line of input contains number of testcases T. For each testcase. First line of each testcase contains number of nodes and edges seperated by space and next line contains N pairs of integers (X and Y each) where X Y means an edge from X to Y.

Output:
For each testcase, print the nodes while doing DFS starting from node 0.

Your task:
The task is to complete the function dfs() which should do the depth first traversal of given graph and prints the node in DFS order.

Constraints:
1 <= T <= 100
1 <= N <= 200

Example:
Input:
2
5 4
0 1 0 2 0 3 2 4

4 3
0 1 1 2 0 3

Output:
0 1 2 4 3    // dfs from node 0
0 1 2 3*/



class Traversal
{
    static void dfs(int src, ArrayList<ArrayList<Integer>> list, boolean vis[])
    {
       // add your code here
       
        vis[src] = true; 
        System.out.print(src+" "); 
  
        // Recur for all the vertices adjacent to this vertex 
        Iterator<Integer> itr = list.get(src).listIterator(); 
        while (itr.hasNext()) 
        { 
            int n = itr.next(); 
            if (!vis[n]) 
                dfs(n,list, vis); 
        } 
    }
}

