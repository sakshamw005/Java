class Solution {
    static int[] dx = {-1,0,1,0} ;
    static int[] dy = {0,1,0,-1} ; 
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0 ;
        for(int i = 0 ; i<grid.length ; i++){
            for(int j = 0 ; j<grid[0].length ; j++){
                if(grid[i][j]==1){
                    ans = Math.max(ans , dfs(i,j,grid)) ;
                }
            }
        }
        return ans ;
    }
    public int dfs(int r , int c , int[][] grid){
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c] == 0){
            return 0 ;
        }
        int curr = 1 ;
        grid[r][c] = 0 ;
        for(int i = 0 ; i<4 ; i++){
            int newr = dx[i] + r ;
            int newc = dy[i] + c ;
            curr += dfs(newr,newc,grid) ;
        }
        return curr ;
    }
}