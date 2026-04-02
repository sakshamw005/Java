class Solution {
public:
    vector<int> dx = {1,0,-1,0};
    vector<int> dy = {0,1,0,-1};
    int longestIncreasingPath(vector<vector<int>>& matrix) {
        int n = matrix.size(), m = matrix[0].size(), ans = 0;
        vector<vector<int>> dp (n , vector<int> (m,-1)) ;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ans = max(ans, solve(matrix, i, j, dp));
            }
        }
        return ans;
    }
    
    int solve(vector<vector<int>>& grid , int r , int c , vector<vector<int>>& dp){
        if(dp[r][c]!=-1){
            return dp[r][c] ;
        }
        int ans = 1 ;        
        for(int i = 0; i < 4; i++){
            int newx = r + dx[i], newy = c + dy[i];
            if(newx >=0 && newx < grid.size() && newy >=0 && newy < grid[0].size() && grid[r][c] < grid[newx][newy]){
                ans = max(ans , 1 + solve(grid,newx,newy,dp)) ;
            }
        }
        
        return dp[r][c] = ans ;
    }
};