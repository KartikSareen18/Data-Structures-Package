import kartik.* ;
import java.util.*;
public class BalancedParenthesis extends LinkedStack
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter String:");
		String inp=sc.next();
		kartik.Stack<Character>s=new kartik.LinkedStack<>();
		int i=0,flag=0;
		while(i<inp.length())
		{
			if(inp.charAt(i)=='(' ||inp.charAt(i)=='[' ||inp.charAt(i)=='{' )
				s.push(inp.charAt(i));
			else
			{
				if(inp.charAt(i)==')' && s.top()=='(')
					s.pop();
				else if(inp.charAt(i)=='}' && s.top()=='{')
					s.pop();
				else if(inp.charAt(i)==']' && s.top()=='[')
					s.pop();
				else
				{
					flag=1;
					break;
				}
			}
			i++;
		}
		if(s.isEmpty() && flag==0)
			System.out.println("Balanced.");
		else
			System.out.println("Not balanced.");
	}
}