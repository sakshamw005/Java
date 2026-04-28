class Solution {
public:
    int minOperations(vector<vector<int>>& grid, int x) {
        vector<int> arr;
        for (auto &r : grid) {
            for (int v : r) {
                arr.push_back(v);
            }
        }
        int rem = arr[0] % x;
        for (int val : arr) {
            if (val % x != rem) return -1;
        }

        sort(arr.begin(), arr.end());

        int mi = arr[arr.size() / 2];

        int ans = 0;
        for (int val : arr) {
            ans += abs(val - mi) / x;
        }

        return ans;
    }
};