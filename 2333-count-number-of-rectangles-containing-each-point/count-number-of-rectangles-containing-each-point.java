class Solution {
    public int[] countRectangles(int[][] a, int[][] b) {
        List<Integer>[] m = new ArrayList[101];

        for (int i = 1; i <= 100; i++) {
            m[i] = new ArrayList<>();
        }

        for (int i = 0; i < a.length; i++) {
            int x = a[i][0];
            int y = a[i][1];
            m[y].add(x);
        }

        for (int i = 1; i <= 100; i++) {
            Collections.sort(m[i]);
        }

        int[] ans = new int[b.length];

        for (int i = 0; i < b.length; i++) {
            int x = b[i][0];
            int y = b[i][1];
            int c = 0;

            for (int h = y; h <= 100; h++) {
                if (m[h].isEmpty()) continue;

                int idx = lb(m[h], x);
                c += m[h].size() - idx;
            }

            ans[i] = c;
        }

        return ans;
    }
    private int lb(List<Integer> l, int val) {
        int i = 0, j = l.size();
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (l.get(mid) < val) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i;
    }
}