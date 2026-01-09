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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return solve(root, depth(root.left), depth(root.right));
    }
    private TreeNode solve(TreeNode root, int l, int r) {
        if (root == null) return null;
        if (l > r)
            return solve(root.left,
                    depth(root.left.left),
                    depth(root.left.right));
        if (r > l)
            return solve(root.right,
                    depth(root.right.left),
                    depth(root.right.right));
        return root;
    }
    private int depth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}