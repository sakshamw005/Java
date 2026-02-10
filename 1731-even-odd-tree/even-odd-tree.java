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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>() ;
        q.add(root) ;
        int lvl = 0 ;
        while(!q.isEmpty()){
            int size = q.size() ;
            int val = (lvl%2==0) ? Integer.MIN_VALUE : Integer.MAX_VALUE ;
            for(int i = 0 ; i<size ; i++){
                TreeNode curr = q.poll();
                if(lvl % 2 == 0) {
                    if (curr.val % 2 == 0 || curr.val <= val) return false;
                } 
                else {
                    if (curr.val % 2 != 0 || curr.val >= val) return false;
                }
                val = curr.val ;
                if(curr.left!=null)q.add(curr.left) ;
                if(curr.right!=null)q.add(curr.right) ;
            }
            lvl++ ;
        }
        return true ;
    }
}