//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;
import java.math.*;

class Node{
    int data;
    Node left, right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

// } Driver Code Ends
//User function Template for Java


class Solution
{
    // Function to find the nodes that are common in both BST.
    public static ArrayList<Integer> findCommon(Node root1, Node root2)
    {
        ArrayList<Integer> result = new ArrayList<>();
        // Perform in-order traversal on both BSTs and compare elements.
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        while (true) {
            if (root1 != null) {
                stack1.push(root1);
                root1 = root1.left;
            } else if (root2 != null) {
                stack2.push(root2);
                root2 = root2.left;
            } else if (!stack1.isEmpty() && !stack2.isEmpty()) {
                root1 = stack1.peek();
                root2 = stack2.peek();

                if (root1.data == root2.data) {
                    result.add(root1.data);
                    stack1.pop();
                    stack2.pop();
                    root1 = root1.right;
                    root2 = root2.right;
                } else if (root1.data < root2.data) {
                    stack1.pop();
                    root1 = root1.right;
                    root2 = null;
                } else {
                    stack2.pop();
                    root2 = root2.right;
                    root1 = null;
                }
            } else {
                break;
            }
        }
        return result;
    }
}


//{ Driver Code Starts.
class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root1 = buildTree(s);
            
            s = br.readLine();
            Node root2 = buildTree(s);
            
            Solution g = new Solution();
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = g.findCommon(root1,root2);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
            
            t--;
        }
    }
}
// } Driver Code Ends