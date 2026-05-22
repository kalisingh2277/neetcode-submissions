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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(check(root,subRoot)==0)
            return true;
        return false;
    }
    public static int check(TreeNode root, TreeNode subRoot)
    {
        if(root==null)
        {
            return -1;
        }
        if(root.val==subRoot.val)
        {
            if(final_check(root,subRoot))
                return 0;
        }
            
        int l=check(root.left,subRoot);
        int r=check(root.right,subRoot);

        return Math.max(l,r);

    }
    public static boolean final_check(TreeNode p, TreeNode q)
    {
        if(p==null || q==null)
            return (p==q);
        return (p.val==q.val) && final_check(p.left,q.left) && final_check(p.right,q.right);
    }
}
