class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        Pair[][] ans = new Pair[grid.length][grid[0].length];
        int cx = 0, cy = 0, res = 0;
        for(int i = 0; i < grid[0].length; i++){
            if(grid[0][i] == 'X') cx++;
            if(grid[0][i] == 'Y') cy++;
            ans[0][i] = new Pair(cx, cy);
            if(cx == cy && cx > 0){
                res++;
            }
        }

        for(int i = 1; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                int ca = (grid[i][j] == 'X' ? 1 : 0) + ans[i-1][j].x;
                int cb = (grid[i][j] == 'Y' ? 1 : 0) + ans[i-1][j].y;

                if(j > 0){
                    ca += ans[i][j-1].x;
                    cb += ans[i][j-1].y;
                    ca -= ans[i-1][j-1].x;
                    cb -= ans[i-1][j-1].y;
                }

                ans[i][j] = new Pair(ca, cb);

                if(ca == cb && ca > 0){
                    res++;
                }
            }
        }

        return res;
    }
    class Pair{
        int x, y;
        public Pair(int cx, int cy){
            this.x = cx;
            this.y = cy;
        }
    }
}