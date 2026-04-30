class Solution {
public:
    int n , m ;
    int maxPathScore(vector<vector<int>>& grid, int k) {
        n = grid.size(), m = grid[0].size();
        vector<vector<vector<int>>> dp(n, vector<vector<int>>(m, vector<int>(k+1, INT_MIN)));
        return solve(grid,0,0,k,0,dp) ;
    }
    int solve(vector<vector<int>>& grid, int r, int c, int k, int cost,vector<vector<vector<int>>>& dp) {
        if(cost > k)return -1 ;
        if(r==n-1 && c==m-1){
            return grid[r][c] ;
        }
        if(dp[r][c][cost]!=INT_MIN){
            return dp[r][c][cost] ;
        }
        int ans = -1 ;
        if(r+1 < n){
            int nc = cost + (grid[r+1][c] == 0 ? 0 : 1);
            int res = solve(grid, r+1, c, k, nc, dp);
            if (res != -1) {
                ans = max(ans, grid[r][c] + res);
            }
        }
        if(c+1 < m){
            int nr = cost + (grid[r][c+1] == 0 ? 0 : 1) ;
            int res = solve(grid,r,c+1,k,nr,dp) ;
            if(res != -1){
                ans = max(ans , grid[r][c] + res) ;
            } 
        }
        return dp[r][c][cost] = ans ;
    }
};