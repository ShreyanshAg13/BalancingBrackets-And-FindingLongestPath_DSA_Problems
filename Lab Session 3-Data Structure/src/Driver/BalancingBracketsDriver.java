package Driver;

import java.util.Scanner;
import java.util.Stack;

public class BalancingBracketsDriver {
	
	static  Boolean checkBalanced(String brack)
	{
		Stack<Character>stck = new Stack<Character>();
		for(int i = 0; i<brack.length(); i++)
		{
			char ch = brack.charAt(i);
			if(ch== '(' || ch == '{' || ch == '[')
				stck.push(ch);
			else if(stck.isEmpty())
				return false;
			else
			{
				char popch = stck.pop();
				switch(ch)
				{
				case ']':
					if (popch == '{' || popch == '(')
						return false;
					break;
				case '}':
					if (popch == '[' || popch == '(')
						return false;
					break;
				case ')':
					if (popch == '{' || popch == '[')
						return false;
					break;		
				}
			}
		}
		return (stck.isEmpty());
	}
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter brackets string:");
		String brack = scan.next();
		if(checkBalanced(brack))
			System.out.println("The entered String has Balanced Brackets");
		else
			System.out.println("The entered Strings do not contain Balanced Brackets");
	}
}
