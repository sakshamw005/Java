class Solution {
    public int minDeletionSize(String[] strs) {
        int m = strs.length, n = strs[0].length();
        boolean[] sorted = new boolean[m - 1];
        int ans = 0;
        for (int c = 0; c < n; c++) {
            boolean bad = false;
            for (int r = 0; r < m - 1; r++) {
                if (!sorted[r] && strs[r].charAt(c) > strs[r + 1].charAt(c)) {
                    bad = true;
                    break;
                }
            }
            if (bad) {
                ans++;
                continue;
            }
            for (int r = 0; r < m - 1; r++) {
                if (!sorted[r] && strs[r].charAt(c) < strs[r + 1].charAt(c)) {
                    sorted[r] = true;
                }
            }
        }
        return ans;
    }
}