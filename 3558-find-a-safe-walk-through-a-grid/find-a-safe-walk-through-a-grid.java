class Solution {

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int[][] best;

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();
        best = new int[n][m];

        for (int i = 0; i < n; i++)
            Arrays.fill(best[i], -1);

        return dfs(grid, 0, 0, health);
    }

    private boolean dfs(List<List<Integer>> grid, int r, int c, int health) {

        if (r < 0 || c < 0 || r >= grid.size() || c >= grid.get(0).size())
            return false;

        if (grid.get(r).get(c) == 1)
            health--;

        if (health <= 0)
            return false;

        if (health <= best[r][c])
            return false;

        best[r][c] = health;

        if (r == grid.size() - 1 && c == grid.get(0).size() - 1)
            return true;

        for (int i = 0; i < 4; i++) {
            if (dfs(grid, r + dx[i], c + dy[i], health))
                return true;
        }

        return false;
    }
}
