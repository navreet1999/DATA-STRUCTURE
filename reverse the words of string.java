/*
Given a String of length S, reverse the whole string without reversing the individual words in it. Words are separated by dots.

Input:
The first line contains T denoting the number of testcases. T testcases follow. Each case contains a string S containing characters.

Output:
For each test case, in a new line, output a single line containing the reversed String.

Constraints:
1 <= T <= 100
1 <= |S| <= 2000

Example:
Input:
2
i.like.this.program.very.much
pqr.mno

Output:
much.very.program.this.like.i
mno.pqr*/



import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void logic(String str)
    {
        int len=str.length();
        String[] words=str.split("\\.");
        int j=0;
        for(j=words.length-1;j>0;j--)
        System.out.print(words[j]+".");
        System.out.println( words[j]);
        
      
    }
	public static void main (String[] args) {
		int t;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		for(int i=0;i<t;i++)
		{
		    String str=sc.next();
		    logic(str);
		}
	}
}
