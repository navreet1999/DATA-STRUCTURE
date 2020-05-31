/*
Given a Directed Graph. Check whether it contains any cycle or not.\

Input: The first line of the input contains an integer 'T' denoting the number of test cases. Then 'T' test cases follow. Each test case consists of two lines. Description of testcases is as follows: The First line of each test case contains two integers 'N' and 'M'  which denotes the no of vertices and no of edges respectively. The Second line of each test case contains 'M'  space separated pairs u and v denoting that there is an uni-directed  edge from u to v .

Output:
The method should return 1 if there is a cycle else it should return 0.

User task:
You don't need to read input or print anything. Your task is to complete the function isCyclic which takes the Graph and the number of vertices and inputs and returns true if the given directed graph contains a cycle. Else, it returns false.

Expected Time Complexity: O(V + E).
Expected Auxiliary Space: O(V).

Constraints:
1 <= T <= 1000
1<= N,M <= 1000
0 <= u,v <= N-1

Example:
Input:
3
2 2
0 1 0 0
4 3
0 1 1 2 2 3
4 3
0 1 2 3 3 2
Output:
1
0
1*/


class DetectCycle
{static boolean dfs(int src, ArrayList<ArrayList<Integer>> list, boolean vis[])
    {
       // add your code here
       if(vis[src])
            return true;
        vis[src]=true;
        // System.out.print(src+" ");
        int size=list.get(src).size();
        for(int i=0;i<size;i++)
            if(dfs(list.get(src).get(i),list,vis))
                return true;
        vis[src]=false;
        return false;
    }
    static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V)
    {
         boolean []vis=new boolean[V];
        Arrays.fill(vis,false);
        for(int i=0;i<V;i++)
            if(dfs(i,list,vis))
                return true;
        return false;
        
    }
}