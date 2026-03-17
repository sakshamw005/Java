class Solution {
public:
    const int dx[4] = {-1,0,1,0} ;
    const int dy[4] = {0,1,0,-1} ; 
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        int ans = 0 ;
        for(int i = 0 ; i<grid.size() ; i++){
            for(int j = 0 ; j<grid[0].size() ; j++){
                if(grid[i][j]==1){
                    ans = max(ans , dfs(i,j,grid)) ;
                }
            }
        }
        return ans ;
    }
    int dfs(int r , int c , vector<vector<int>>& grid){
        if(r<0 || r>=grid.size() || c<0 || c>=grid[0].size() || grid[r][c] == 0){
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
};