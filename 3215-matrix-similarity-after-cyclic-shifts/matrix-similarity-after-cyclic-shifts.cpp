class Solution {
public:
    bool areSimilar(vector<vector<int>>& mat, int k) {
        int m = mat.size();
        int n = mat[0].size();
        k = k % n; 
        for(int i = 0; i < m; i++) {
            vector<int> ans(n);
            
            for(int j = 0; j < n; j++) {
                if(i % 2 == 0) {
                    ans[j] = mat[i][(j + k) % n];
                } else {
                    ans[j] = mat[i][(j - k + n) % n];
                }
            }
            for(int j = 0; j < n; j++) {
                if(ans[j] != mat[i][j]) return false;
            }
        }
        return true;
    }
};