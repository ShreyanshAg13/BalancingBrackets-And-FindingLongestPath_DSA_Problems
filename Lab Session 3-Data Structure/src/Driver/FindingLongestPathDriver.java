package Driver;

import java.util.ArrayList;

public class FindingLongestPathDriver {
	
	static class Node
	{
	    Node left;
	    Node right;
	    int data;
	};
	
	static Node newNode(int data)
	{
	    Node tree = new Node();
	 
	    tree.data = data;
	    tree.left = null;
	    tree.right = null;
	 
	    return tree;
	}
	
	public static ArrayList<Integer> finLongPath(Node root)
	{
	     
	    if(root == null)
	    {
	        ArrayList<Integer> path = new ArrayList<>();
	        return path;
	    }
	     
	    ArrayList<Integer> right = finLongPath(root.right);
	     
	    ArrayList<Integer> left = finLongPath(root.left);
	     
	    if(right.size() < left.size())
	    {
	        left.add(root.data);
	    }
	    else
	    {
	        right.add(root.data);
	    }
	     
	    return (left.size() > right.size() ? left :right);
	}
	
	public static void main(String[] args)
	{
	    Node root = newNode(100);
		root.left = newNode(20);
		root.right = newNode(130);
		root.left.left = newNode(10);
		root.left.right = newNode(50);
		root.right.left = newNode(110);
		root.right.right = newNode(140);
		root.left.left.left = newNode(5);
	     
	    ArrayList<Integer> path = finLongPath(root);
	    int length = path.size();
	     
	    System.out.print(path.get(length - 1));
	    for(int i = length - 2; i >= 0; i--)
	    {
	        System.out.print(" -> " + path.get(i));
	    }
	}
	
}
