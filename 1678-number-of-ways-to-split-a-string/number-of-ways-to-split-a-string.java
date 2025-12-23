class Solution {
    int MOD = 1_000_000_007;
    public int numWays(String s) {
        int sum = 0 ;
        long n = s.length();
        for(char x : s.toCharArray())sum+=(x-'0') ;
        if (sum == 0) {
            long ans = ((n - 1) * (n - 2) / 2) % MOD;
            return (int) ans ;
        }
        if (sum % 3 != 0)return 0;
        long ones = sum / 3;
        sum = 0;
        long part1 = 0, part2 = 0;
        for (char c : s.toCharArray()) {
            if (c == '1')sum++;
            if (sum == ones)part1++;
            if (sum == 2 * ones)part2++;
        }
        return (int) ((part1 * part2) % MOD);
    }
}