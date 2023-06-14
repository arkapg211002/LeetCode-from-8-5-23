/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    List<Integer>l=new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        int min=Integer.MAX_VALUE;
        for(int i=1;i<l.size();i++)
        {
            min=(int)Math.min(min,(int)Math.abs(l.get(i)-l.get(i-1)));
        }
        return min;
        
    }
    public void traverse(TreeNode root)
    {
        if(root==null)return;
        traverse(root.left);
        l.add(root.val);
        traverse(root.right);
    }
}

/*
class Solution {
    List<Integer>l=new ArrayList<>();
    public int minDiffInBST(TreeNode root) {
        traverse(root);
        /*int min=Integer.MAX_VALUE;
        for(int i=1;i<l.size();i++)
            min=(int)Math.min(min,(int)Math.abs(l.get(i)-l.get(i-1)));
        //return min;
        Collections.sort(l);
        return l.get(0);
    }
    public void traverse(TreeNode root)
    {
        if(root==null)return;
        traverse(root.left);
        //l.add(root.val);
        if(root.left!=null && root.right!=null)
        {
            //l.add((int)Math.abs(root.left.val-root.right.val));
            int left=(int)Math.abs(root.left.val-root.val);
            int right=(int)Math.abs(root.right.val-root.val);
            l.add(left);
            l.add(right);
        }
        else if(root.left!=null && root.right==null)l.add((int)Math.abs(root.val-root.left.val));
        else if(root.left==null && root.right!=null)l.add((int)Math.abs(root.val-root.right.val));
        traverse(root.right);
    }
}*/
