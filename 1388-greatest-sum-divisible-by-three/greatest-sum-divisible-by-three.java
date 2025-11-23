class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum=Arrays.stream(nums).sum();
        if(sum%3==0)
        return sum;
        Integer[][] memo = new Integer[nums.length][3];
        int ans = dfs(nums, 0, 0, memo);
        return ans < 0 ? 0 : ans; 
    }

    private int dfs(int[] nums, int i, int mod, Integer[][] memo) {
        if (i == nums.length) {
            return (mod == 0) ? 0 : Integer.MIN_VALUE;
        }
        if (memo[i][mod] != null) return memo[i][mod];

        int take = nums[i] + dfs(nums, i + 1, (mod + nums[i]) % 3, memo);
        int skip = dfs(nums, i + 1, mod, memo);

        return memo[i][mod] = Math.max(take, skip);
    }
}
