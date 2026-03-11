class Solution {
public:
    vector<int> getRow(int ri) {
        int lvl = 1;
        vector<int> l;
        l.push_back(1);

        while(lvl <= ri) {
            vector<int> ans;
            ans.push_back(1);

            for(int i = 1; i < lvl; i++) {
                ans.push_back(l[i-1] + l[i]);
            }

            ans.push_back(1);
            l = ans;
            lvl++;
        }

        return l;
    }
};