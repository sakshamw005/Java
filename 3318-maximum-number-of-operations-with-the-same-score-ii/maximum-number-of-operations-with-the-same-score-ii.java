class Solution {
    public int maxOperations(int[] nums) {
        int ans = 0;
        int len = nums.length;
        int[][] memo = new int[len][len];
        int start = 0;
        int end = len - 1;

        ans = Math.max(ans, helper(nums, start + 2, end, nums[start] + nums[start + 1], memo) + 1);
        ans = Math.max(ans, helper(nums, start + 1, end - 1, nums[start] + nums[end], memo) + 1);
        ans = Math.max(ans, helper(nums, start, end - 2, nums[end] + nums[end - 1], memo) + 1);

        return ans ;
    }

    private int helper(int[] nums, int left, int right, int previousSum, int[][] memo) {
        if (left >= right)
            return 0;
        if (memo[left][right] != 0)
            return memo[left][right];

        int maxOps = 0;
        if (nums[left] + nums[left + 1] == previousSum)
            maxOps = Math.max(maxOps, helper(nums, left + 2, right, previousSum, memo) + 1);
        if (nums[left] + nums[right] == previousSum)
            maxOps = Math.max(maxOps, helper(nums, left + 1, right - 1, previousSum, memo) + 1);
        if (nums[right] + nums[right - 1] == previousSum)
            maxOps = Math.max(maxOps, helper(nums, left, right - 2, previousSum, memo) + 1);

        return memo[left][right] = maxOps;
    }
}