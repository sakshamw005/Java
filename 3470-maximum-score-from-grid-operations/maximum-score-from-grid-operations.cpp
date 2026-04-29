using vll = vector<long long>;
class Solution {
public:
    long long maximumScore(vector<vector<int>>& grid) {
        int n = grid[0].size();
        if (n == 1) {
            return 0;
        }

        vector<vector<vll>> dp(n, vector<vll>(n + 1, vll(n + 1, 0)));
        vector<vll> pm(n + 1, vll(n + 1, 0));
        vector<vll> psm(n + 1, vll(n + 1, 0));
        vector<vll> csum(n, vll(n + 1, 0));

        for (int c = 0; c < n; c++) {
            for (int r = 1; r <= n; r++) {
                csum[c][r] = csum[c][r - 1] + grid[r - 1][c];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int ch = 0; ch <= n; ch++) {
                for (int ph = 0; ph <= n; ph++) {
                    if (ch <= ph) {
                        long long extraScore =
                            csum[i][ph] - csum[i][ch];
                        dp[i][ch][ph] =
                            std::max(dp[i][ch][ph],
                                     psm[ph][0] + extraScore);
                    } else {
                        long long extraScore =
                            csum[i - 1][ch] - csum[i - 1][ph];
                        dp[i][ch][ph] = std::max(
                            {dp[i][ch][ph], psm[ph][ch],
                             pm[ph][ch] + extraScore});
                    }
                }
            }

            for (int ch = 0; ch <= n; ch++) {
                pm[ch][0] = dp[i][ch][0];
                for (int ph = 1; ph <= n; ph++) {
                    long long penalty =
                        (ph > ch) ? (csum[i][ph] - csum[i][ch])
                                        : 0;
                    pm[ch][ph] =
                        max(pm[ch][ph - 1],dp[i][ch][ph] - penalty);
                }

                psm[ch][n] = dp[i][ch][n];
                for (int ph = n - 1; ph >= 0; ph--) {
                    psm[ch][ph] = std::max(
                        psm[ch][ph + 1], dp[i][ch][ph]);
                }
            }
        }
        long long ans = 0;
        for (int k = 0; k <= n; k++) {
            ans = max({ans, dp[n - 1][n][k], dp[n - 1][0][k]});
        }
        return ans;
    }
};