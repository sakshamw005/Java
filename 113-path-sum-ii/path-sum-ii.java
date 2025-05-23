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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>() ;
        List<Integer> l = new ArrayList<>() ;
        if(root==null){
            return ans ;
        }
        print(ans,root,0,targetSum,l) ;
        return ans ;
    }
    public void print(List<List<Integer>> ans ,TreeNode root , int curr , int targetSum,List<Integer> l){
        if(root==null){
            return ;
        }
        int n = root.val ;
        l.add(n) ;
        curr+=n ;
        if (root.left == null && root.right == null && curr == targetSum) {
            ans.add(new ArrayList<>(l));
        } else {
            print(ans, root.left, curr, targetSum, l);
            print(ans, root.right, curr, targetSum, l);
        }

        l.remove(l.size() - 1);
    }
}