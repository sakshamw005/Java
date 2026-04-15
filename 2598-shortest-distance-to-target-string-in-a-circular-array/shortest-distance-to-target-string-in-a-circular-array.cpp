class Solution {
public:
    int closestTarget(vector<string>& words, string target, int si) {
        int n = words.size();
        int ans = n;
        
        for(int i = 0; i < n; i++) {
            if(words[i] == target) {
                int d = abs(i - si);
                ans = min(ans, min(d, n - d));
            }
        }
        return (ans == n ? -1 : ans);
    }
};