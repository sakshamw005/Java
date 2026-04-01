class Solution {
public:
    vector<int> findOrder(int n, vector<vector<int>>& prerequisites) {
        vector<int> ans(n);
        vector<int> in(n, 0);
        queue<int> q;
        unordered_map<int, vector<int>> map;

        for (int i = 0; i < n; i++) {
            map[i] = vector<int>();
        }

        for (int i = 0; i < prerequisites.size(); i++) {
            map[prerequisites[i][1]].push_back(prerequisites[i][0]);
            in[prerequisites[i][0]]++;
        }

        int idx = 0;

        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                q.push(i);
                ans[idx++] = i;
            }
        }

        while (!q.empty()) {
            int cur = q.front();
            q.pop();

            for (int i : map[cur]) {
                in[i]--;
                if (in[i] == 0) {
                    q.push(i);
                    ans[idx++] = i;
                }
            }
        }

        if (idx != n) return {};

        return ans;
    }
};