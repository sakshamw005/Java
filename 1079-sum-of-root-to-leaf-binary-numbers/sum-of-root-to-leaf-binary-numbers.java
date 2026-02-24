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
    int ans = 0 ;
    public int sumRootToLeaf(TreeNode root) {
        print(root,0) ;
        return ans ;
    }
    public void print(TreeNode root,int sum){
        if(root==null)return ;
        sum = sum*2 + root.val ;
        if(root.left==null && root.right==null){
            ans+=sum ;
        }
        print(root.left,sum) ;
        print(root.right,sum) ;
    }
}