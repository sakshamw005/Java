class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i < n; i++) {
            int a = i;
            int b = n - i;
            if (!containsZero(a) && !containsZero(b)) {
                return new int[]{a, b};
            }
        }
        return new int[]{};
    }

    private boolean containsZero(int n) {
        while (n > 0) {
            if (n % 10 == 0) return true;
            n /= 10;
        }
        return false;
    }
}