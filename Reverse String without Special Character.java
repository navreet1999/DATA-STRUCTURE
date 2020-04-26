/*
Given a string S, containing special characters and all the alphabets, reverse the string without
affecting the positions of the special characters.
 

Input
The first line of input contains an integer T denoting the number of test cases. Then T test cases
follow. 
The first line of each test case contains a case-insensitive string S.


Output
Print out the reversed string without  affecting special characters.


Constraints
1 <= T <= 100
0 <   S  <= 100

 

Examples

Input
3
A&B
abc%sld*
dakA&*hA@#N

Output
B&A
dls%cba*
NAhA&*ka@#d
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    public static void logic(String s)
    {
        int len=s.length()-1;
        int l=0,r=len;
        char[] str=s.toCharArray();
        while(l<r)
        {
            if(!Character.isLetter(str[l]))
            l++;
            else if(!Character.isLetter(str[r]))
            r--;
            else
            {
                char temp;
                temp=str[l];
                str[l]=str[r];
                str[r]=temp;
                l++;r--;
            }
        }
         String rev= String.valueOf(str);
        System.out.println(rev);
        
      
       
    }
	public static void main (String[] args) {
		
		Scanner sc=new Scanner(System.in);
		String line1=sc.nextLine();
		int n=Integer.parseInt(line1);
	
		for(int i=0;i<n;i++)
		{
		   String str= sc.nextLine(); 
		    logic(str);
		}
	}
}
