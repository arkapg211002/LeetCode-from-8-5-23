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
    int path=0;
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] freq=new int[10];
        traverse(root,freq);
        return path;
    }
    public void traverse(TreeNode root,int[] freq)
    {
        if(root==null)
            return;
        freq[root.val]++;
        if(root.left==null && root.right==null)
        {
            int odd=0;
            for(int i=0;i<freq.length;i++)
            {
                if(freq[i]%2!=0)
                    odd++;
                if(odd>1)
                    break;
            }
            if(odd<=1)
                path++;
            freq[root.val]--;
            return;
        }
        else
        {
        traverse(root.left,freq);
        traverse(root.right,freq);
        }
        freq[root.val]--;
    }
}