/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<TreeNode>b=new ArrayList<>();
    List<Integer>l=new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //b=new ArrayList<>();
        boolean found=find(root,target.val);
        for(int i=0;i<b.size();i++)
        {
            klevelsdown(b.get(i),k-i,(i==0)?null:b.get(i-1));
        }
        return l;
    }
    public boolean find(TreeNode n,int d)
    {
        if(n==null)return false;
        if(n.val==d)
        {
            b.add(n);
            return true;
        }
        boolean lt=find(n.left,d);
        if(lt==true)
        {
            b.add(n);
            return true;
        }
        boolean rt=find(n.right,d);
        if(rt==true)
        {
            b.add(n);
            return true;
        }
        return false;
    }
    public void klevelsdown(TreeNode p,int k,TreeNode next)
    {
        if(p==null || k<0 || p==next)return;
        if(k==0)l.add(p.val);
        klevelsdown(p.left,k-1,next);
        klevelsdown(p.right,k-1,next);
    }
}