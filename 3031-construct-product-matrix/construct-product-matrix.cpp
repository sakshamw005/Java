class Solution {
public:
    vector<vector<int>> constructProductMatrix(vector<vector<int>>& grid) {
        int m = grid.size() , n = grid[0].size() ;
        vector<vector<long long>> pref (m,vector<long long>(n,1)) ;
        vector<vector<long long>> suff (m,vector<long long>(n,1)) ;
        long long prod = 1 ;
        for(int i = 0 ; i<m ; i++){
            for(int j = 0 ; j<n ; j++){
                pref[i][j] = prod;
                prod = (prod * grid[i][j])%12345 ;
            }
        }
        prod = 1 ;
        for(int i = m-1 ; i>=0 ; i--){
            for(int j = n-1 ; j>=0 ; j--){
                suff[i][j] = prod;
                prod = (prod * grid[i][j])%12345 ;
            }
        }
        // for(auto i : pref){
        //     for(int j : i)cout << j << " " ;
        //     cout << endl ;
        // }
        // for(auto i : suff){
        //     for(int j : i)cout << j << " " ;
        //     cout << endl ;
        // }
        vector<vector<int>> ans(m, vector<int>(n));
        for(int i = 0 ; i<m ; i++){
            for(int j = 0 ; j<n ; j++){
                ans[i][j] = (pref[i][j] * suff[i][j])%12345 ;
            }
        }
        return ans ;
    }
};