class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) return -1;

        int l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
        for (int i : bloomDay) {
            l = Math.min(l, i);
            r = Math.max(r, i);
        }

        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (possible(mid, bloomDay, m, k)) {
                ans = mid;
                r = mid - 1;   // try smaller day
            } else {
                l = mid + 1;   // need more days
            }
        }
        return ans;
    }

    public boolean possible(int day, int[] arr, int m, int k) {
        int bouquets = 0;
        int flowers = 0;

        for (int i : arr) {
            if (i <= day) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        return bouquets >= m;
    }
}