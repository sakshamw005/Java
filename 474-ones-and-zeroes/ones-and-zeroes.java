class Solution {
    static int[][][] dp; 
    public int findMaxForm(String[] strs, int m, int n) {
        // dp : [index][zerosLeft][onesLeft]
        dp = new int[strs.length][m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return solve(strs, m, n, 0);
    }

    public int solve(String[] strs, int m, int n, int i) {
        if (i == strs.length) {
            return 0;
        }
        if (dp[i][m][n] != -1) {
            return dp[i][m][n];
        }

        int[] curr = calc(strs[i]);
        int zeros = curr[0], ones = curr[1];

        int skip = solve(strs, m, n, i + 1);

        int take = 0;
        if (zeros <= m && ones <= n) {
            take = 1 + solve(strs, m - zeros, n - ones, i + 1);
        }

        dp[i][m][n] = Math.max(skip, take);
        return dp[i][m][n];
    }

    public int[] calc(String a) {
        int z = 0;
        for (char x : a.toCharArray()) if (x == '0') z++;
        return new int[]{z, a.length() - z};
    }
}