class Solution {
public:
    int maxProductPath(vector<vector<int>>& grid) {
        int n = grid.size(), m = grid[0].size();
        const long mod = 1e9 + 7;
        vector<vector<long long>> maxti(n, vector<long long>(m));
        vector<vector<long long>> minti(n, vector<long long>(m));

        maxti[0][0] = minti[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            maxti[i][0] = minti[i][0] = maxti[i-1][0] * grid[i][0];
        }
        for (int j = 1; j < m; j++) {
            maxti[0][j] = minti[0][j] = maxti[0][j-1] * grid[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {

                long long a = maxti[i-1][j] * grid[i][j];
                long long b = minti[i-1][j] * grid[i][j];
                long long c = maxti[i][j-1] * grid[i][j];
                long long d = minti[i][j-1] * grid[i][j];

                maxti[i][j] = max({a, b, c, d});
                minti[i][j] = min({a, b, c, d});
            }
        }

        long long ans = maxti[n-1][m-1];
        return ans < 0 ? -1 : ans % mod;
    }
};