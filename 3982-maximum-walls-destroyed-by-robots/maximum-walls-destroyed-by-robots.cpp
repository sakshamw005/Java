class Solution {
public:
    int maxWalls(vector<int>& robots, vector<int>& distance, vector<int>& walls) {
        int n = robots.size();
        vector<pair<int,int>> r;
        for(int i=0;i<n;i++) r.push_back({robots[i], distance[i]});
        sort(r.begin(), r.end());
        sort(walls.begin(), walls.end());

        pair<int,int> L = {-1,0}, R = {-1,0};

        for(int i=0;i<n;i++){
            int pos = r[i].first;
            int d = r[i].second;

            int lb = pos - d;
            if(i > 0) lb = max(lb, r[i-1].first);

            int rb = pos + d;
            if(i < n-1) rb = min(rb, r[i+1].first);

            int l1 = lower_bound(walls.begin(), walls.end(), lb) - walls.begin();
            int r1 = upper_bound(walls.begin(), walls.end(), pos) - walls.begin() - 1;

            int l2 = lower_bound(walls.begin(), walls.end(), pos) - walls.begin();
            int r2 = upper_bound(walls.begin(), walls.end(), rb) - walls.begin() - 1;

            pair<int,int> nL = L, nR = R;

            if(l1 <= r1){
                int gain = max(0, r1 - max(l1, L.first+1) + 1);
                nL = max(nL, {r1, L.second + gain});
                gain = max(0, r1 - max(l1, R.first+1) + 1);
                nL = max(nL, {r1, R.second + gain});
            }

            if(l2 <= r2){
                int gain = max(0, r2 - max(l2, L.first+1) + 1);
                nR = max(nR, {r2, L.second + gain});
                gain = max(0, r2 - max(l2, R.first+1) + 1);
                nR = max(nR, {r2, R.second + gain});
            }

            L = nL;
            R = nR;
        }

        return max(L.second, R.second);
    }
};