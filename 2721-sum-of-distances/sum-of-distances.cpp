class Solution {
public:
    vector<long long> distance(vector<int>& nums) {
        unordered_map<int, vector<int>> ma;
        for (int i = 0; i < nums.size(); i++) {
            ma[nums[i]].push_back(i);
        }
        vector<long long> ans(nums.size(), 0);
        for (auto &it : ma) {
            vector<int> &pos = it.second;
            int n = pos.size();
            if (n == 1) continue;
            vector<long long> prefix(n + 1, 0);
            for (int i = 0; i < n; i++) {
                prefix[i + 1] = prefix[i] + pos[i];
            }
            for (int i = 0; i < n; i++) {
                long long left = (long long)pos[i] * i - prefix[i];
                long long right = (prefix[n] - prefix[i + 1]) - (long long)pos[i] * (n - i - 1);
                ans[pos[i]] = left + right;
            }
        }

        return ans;
    }
};