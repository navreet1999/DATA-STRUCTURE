/*
Given a string S. The task is to print all permutations of a given string.

Input:
The first line of input contains an integer T, denoting the number of test cases. Each test case contains a single string S in capital letter.

Output:
For each test case, print all permutations of a given string S with single space and all permutations should be in lexicographically increasing order.

Constraints:
1 ≤ T ≤ 10
1 ≤ size of string ≤ 5

Example:
Input:
2
ABC
ABSG

Output:
ABC ACB BAC BCA CAB CBA 
ABGS ABSG AGBS AGSB ASBG ASGB BAGS BASG BGAS BGSA BSAG BSGA GABS GASB GBAS GBSA GSAB GSBA SABG SAGB SBAG SBGA SGAB SGBA

Explanation:
Testcase 1: Given string ABC has permutations in 6 forms as ABC, ACB, BAC, BCA, CAB and CBA .*/



import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    public static String swap(String str,int i,int j)
    {
        char temp;
        char[] arr=str.toCharArray();
       
        temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        return String.valueOf(arr);
    }
    public static void permutation(String prefix,String str)
    {
        int n=str.length();
	    if(n==0) {System.out.print(prefix+" ");
	       
	    }
	    else {
	        for(int i=0;i<n;i++)
	        {
	            permutation(prefix+str.charAt(i), str.substring(0,i)+str.substring(i+1,n));
	        }
	    }
    }
	public static void main (String[] args) {
		
		int t;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		for(int i=0;i<t;i++)
		{
		    String str=sc.next();
		    char[] a=str.toCharArray();
		    Arrays.sort(a);
		    str=String.valueOf(a);
		    permutation("",str);
		     System.out.println( );
		}
	}
}