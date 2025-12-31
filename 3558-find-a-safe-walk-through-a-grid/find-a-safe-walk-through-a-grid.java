class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int n = grid.size();
        int m = grid.get(0).size();

        int[][] best = new int[n][m];
        for (int i = 0; i < n; i++)
            Arrays.fill(best[i], -1);

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, health});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], h = cur[2];

            if (grid.get(r).get(c) == 1)
                h--;

            if (h <= 0)
                continue;

            if (r == n - 1 && c == m - 1)
                return true;

            if (h <= best[r][c])
                continue;

            best[r][c] = h;

            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                    q.add(new int[]{nr, nc, h});
                }
            }
        }

        return false;
    }
}