class Solution {
    public boolean isValidBST(TreeNode root) {
        return ValidBST(root).isbst;
    }

    public BstPair ValidBST(TreeNode root) {
        if (root == null) {
            return new BstPair(); 
        }

        BstPair lbp = ValidBST(root.left);
        BstPair rbp = ValidBST(root.right);

        BstPair sbp = new BstPair();
        sbp.min = Math.min(root.val, Math.min(lbp.min, rbp.min));
        sbp.max = Math.max(root.val, Math.max(lbp.max, rbp.max));

        sbp.isbst = lbp.isbst && rbp.isbst && lbp.max < root.val && rbp.min > root.val;

        return sbp;
    }

    class BstPair {
        boolean isbst = true;
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
    }
}