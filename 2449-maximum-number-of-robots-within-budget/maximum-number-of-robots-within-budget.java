class Solution {
    public int maximumRobots(int[] a, int[] b, long c) {
        int n = a.length;
        long s = 0;
        int l = 0, ans = 0;
        Deque<Integer> q = new ArrayDeque<>();

        for (int r = 0; r < n; r++) {
            s += b[r];

            while (!q.isEmpty() && a[q.peekLast()] <= a[r]) {
                q.pollLast();
            }
            q.addLast(r);

            while (!q.isEmpty() && a[q.peekFirst()] + (long)(r - l + 1) * s > c) {
                if (q.peekFirst() == l) q.pollFirst();
                s -= b[l];
                l++;
            }

            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}