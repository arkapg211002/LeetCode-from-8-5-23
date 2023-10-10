//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

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
    
    public static void main(String args[]) throws IOException
    {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            Solution T = new Solution();
            int target = Integer.parseInt(br.readLine().trim());
            int k = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = T.KDistanceNodes(root,target,k);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right;
// }

class Solution
{
    static Node tar;
    static HashMap<Node,Node> hp=new HashMap<>();
    static ArrayList<Integer> res;
    static HashMap<Node,Boolean> visited=new HashMap<>();
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        res=new ArrayList<Integer>();
        getparents(root,target);
        hp.put(root,null);
        getresult(tar,k,0);
        Collections.sort(res);
        return res;
        
    }
    public static void getresult(Node root,int k,int dist)
    {
        if(dist==k)
        {
            res.add(root.data);
            return;
        }
        visited.put(root,true);
        if(root.left!=null && visited.get(root.left)==null)
        {
            getresult(root.left,k,dist+1);
        }
        if(root.right!=null && visited.get(root.right)==null)
        {
            getresult(root.right,k,dist+1);
        }
        if(hp.get(root)!=null && visited.get(hp.get(root))==null)
        {
            getresult(hp.get(root),k,dist+1);
        }
        return;
    }
    public static void getparents(Node root,int target)
    {
        if(root==null)
            return;
        if(root.data==target)
            tar=root;
        if(root.left!=null)
            hp.put(root.left,root);
            getparents(root.left,target);
        if(root.right!=null)
            hp.put(root.right,root);
            getparents(root.right,target);
        return;
    }
};
