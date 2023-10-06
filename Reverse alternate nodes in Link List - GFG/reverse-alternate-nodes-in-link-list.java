//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Rearr
{
    static Node head;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  =sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                temp.next = new Node(a);
                temp = temp.next;
            }
            
            Solution ob = new Solution();
            ob.rearrange(head);
            printLast(head);
            System.out.println();
        }
    }
    
    public static void printLast(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/
class Solution
{
    public static void rearrange(Node odd)
    {
        // add your code here
        if(odd.next==null || odd==null)return ;
        Node fst=null,scd=null,p=null,q=null,r=odd;
        
        /// creating two list fst-starts from first ,scd starts from second and adds alternate nodes
        boolean f=false;
        while(r!=null){
           
            if(f==false){
                if(fst==null){
                p=fst=r;
                }
                else{
                p.next=r;
                 p=p.next;
                }
              
               f=true;
            }
            else{
                
                if(scd==null){
                q=scd=r;
                }else{
                q.next=r;
                q=q.next;
                }
                f=false;
            }
            
            r=r.next;
        }
        p.next=null;// removing last link of the lists
        q.next=null;// removing last link of the lists
        // reversing second list which are alternate 
        p=scd.next;
        q=scd;
        r=null;
        
        while(p!=null){
            q.next=r;
            r=q;
            q=p;
            p=p.next;
        }
          
          q.next=r;// q had list of alternate and reversed list
          
          p=fst;
          //appending second list into first lists last node
          
          while(p.next!=null)
              p=p.next;
          
          p.next=q; // appending the second rversed list present in the name "q"
    }
}
