class Solution {
    public int concatenatedBinary(int n) {
        int mod = 1_000_000_007;
        long res = 0;
        int len = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) len++;
            res = ((res << len) % mod + i) % mod;
        }
        return (int) res;
    }
}