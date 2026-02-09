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
    public TreeNode reverseOddLevels(TreeNode root) {
        dfs(root.left,root.right,1) ;
        return root ;
    }
    public void dfs(TreeNode lst , TreeNode rst , int lvl){
        if(lst==null || rst==null)return ;
        if(lvl%2!=0){
            int temp = lst.val ;
            lst.val = rst.val ;
            rst.val = temp ;
        }
        dfs(lst.left,rst.right,lvl+1) ;
        dfs(rst.left,lst.right,lvl+1) ;
    }
}