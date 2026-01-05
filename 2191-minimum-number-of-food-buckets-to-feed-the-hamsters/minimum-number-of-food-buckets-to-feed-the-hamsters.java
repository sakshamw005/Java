class Solution {
    public int minimumBuckets(String h) {
        int n = h.length();
        if (n == 1 && h.charAt(0) == 'H') return -1;
        int ans = 0;
        int prev = -1; 
        for (int i = 0; i < n; i++) {
            if (h.charAt(i) == 'H') {
                if (i > 0 && prev == i - 1) continue;
                if (i + 1 < n && h.charAt(i + 1) == '.') {
                    ans++;
                    prev = i + 1;
                }
                else if (i > 0 && h.charAt(i - 1) == '.') {
                    ans++;
                    prev = i - 1;
                }
                else {
                    return -1;
                }
            }
        }
        return ans;
    }
}