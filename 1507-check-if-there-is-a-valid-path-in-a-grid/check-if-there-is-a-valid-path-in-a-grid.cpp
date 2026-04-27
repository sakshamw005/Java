class Solution {
public:
    vector<vector<vector<int>>> dir = {
        {},
        {{0,-1},{0,1}},
        {{-1,0},{1,0}},
        {{0,-1},{1,0}},
        {{0,1},{1,0}},
        {{0,-1},{-1,0}},
        {{0,1},{-1,0}}
    };
    bool hasValidPath(vector<vector<int>>& grid) {
        int n = grid.size() , m = grid[0].size() ;
        vector<vector<bool>> vis(n,vector<bool> (m , false)) ;
        return dfs(vis,0,0,grid) ;
    }
    bool dfs(vector<vector<bool>>& vis, int r , int c , vector<vector<int>>& grid){
        int n = grid.size() , m = grid[0].size() ;
        if(r==n-1 && c==m-1)return true ;
        vis[r][c] = true;
        for(auto& i : dir[grid[r][c]]){
            int nr = i[0] + r , nc = i[1] + c ;
            if (nr < 0 || nc < 0 || nr >= n || nc >= m || vis[nr][nc]) continue;
            for(auto& j : dir[grid[nr][nc]]){
                if(nr+j[0]==r && nc+j[1]==c){
                    if(dfs(vis,nr,nc,grid))return true ;
                }
            }
        }
        return false ;
    }
};