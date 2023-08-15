//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        PrintWriter out=new PrintWriter(System.out);
	        int test = Integer.parseInt(br.readLine());
	        while(test-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	int key = Integer.parseInt(br.readLine());
        	    Solution obj = new Solution();
        	    Node res = obj.nextRight(root, key);
        	    out.println(res.data);
        }
        out.close();
    }
  
}

// } Driver Code Ends


//User function Template for Java
class Solution{
	Node nextRight(Node node, int key)
    {
		//Write your code here
		Queue<Node> pq=new ArrayDeque<>();
        pq.add(node);
        Node temp=new Node(-1);
        while(pq.size()>0)
        {
             int count=pq.size();
  
            for(int i=0;i<count;i++)
            {
                Node root=pq.remove();
                 if(root.data==key)
                 {
                    if(pq.size()>0 && i+1<count)
                    {
                        Node curr=pq.remove();
                        return curr;
                    }
                 }
                 
                 if(root.left!=null)
                    pq.add(root.left);
                 if(root.right!=null)
                    pq.add(root.right);
            }
        }
        
        return temp;
    }
}

