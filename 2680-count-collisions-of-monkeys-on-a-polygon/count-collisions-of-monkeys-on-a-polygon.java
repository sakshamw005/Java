class Solution {
    private int MOD = 1000_000_007 ;
    public int monkeyMove(int n) {
        return (int)((modPow(2, n, MOD) - 2 + MOD) % MOD);
    }
    private long modPow(long base, long exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}