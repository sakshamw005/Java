class Solution {
    long sum = 0;
    long ans = 0;
    static final int MOD = 1_000_000_007;
    public int maxProduct(TreeNode root) {
        sum = find(root);
        solve(root);
        return (int)(ans % MOD);
    }
    public long find(TreeNode root) {
        if (root == null) return 0;
        return root.val + find(root.left) + find(root.right);
    }
    public long solve(TreeNode root) {
        if (root == null) return 0;
        long left = solve(root.left);
        long right = solve(root.right);
        long summ = left + right + root.val;
        ans = Math.max(ans, summ * (sum - summ));
        return summ;
    }
}