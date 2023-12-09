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

public List inorderTraversal(TreeNode root) {

List<Integer> list = new ArrayList<Integer>();
in(root,list);
return list;
}

public void in(TreeNode root,List list){

if(root==null)
    return;
in(root.left,list);
list.add(root.val);
in(root.right,list);
}
}