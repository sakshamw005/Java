class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;

        List<List<Integer>> ll = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[][] b = new boolean[m][n];
                boolean[] res = possible(i, j, heights, b);
                if (res[0] && res[1]) {
                    ll.add(Arrays.asList(i, j));
                }
            }
        }
        return ll;
    }

    public boolean[] possible(int row, int col, int[][] m, boolean[][] b) {
        if (b[row][col]) return new boolean[]{false, false};
        b[row][col] = true;

        boolean pa = row == 0 || col == 0;
        boolean at = row == m.length - 1 || col == m[0].length - 1;

        // right
        if (col + 1 < m[0].length && m[row][col] >= m[row][col + 1]) {
            boolean[] res = possible(row, col + 1, m, b);
            pa |= res[0];
            at |= res[1];
        }
        // up
        if (row - 1 >= 0 && m[row][col] >= m[row - 1][col]) {
            boolean[] res = possible(row - 1, col, m, b);
            pa |= res[0];
            at |= res[1];
        }
        // left
        if (col - 1 >= 0 && m[row][col] >= m[row][col - 1]) {
            boolean[] res = possible(row, col - 1, m, b);
            pa |= res[0];
            at |= res[1];
        }
        // down
        if (row + 1 < m.length && m[row][col] >= m[row + 1][col]) {
            boolean[] res = possible(row + 1, col, m, b);
            pa |= res[0];
            at |= res[1];
        }

        return new boolean[]{pa, at};
    }
}
