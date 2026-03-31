class Solution {
public:
    unordered_map<string,bool> dp ;
    bool isScramble(string s1, string s2) {
        return solve(s1, s2);
    }
    bool solve(string s1, string s2){
        if(s1 == s2) return true;
        string t1 = s1, t2 = s2;
        sort(t1.begin(), t1.end());
        sort(t2.begin(), t2.end());
        if(t1 != t2) return false;

        string key = s1 + "@" + s2 ;
        if(dp.count(key)){
            return dp[key] ;
        }
        bool bjp = false; 

        for(int i = 1; i < s1.size(); i++){
            string a1 = s1.substr(0, i);
            string b1 = s1.substr(i);

            string a2 = s2.substr(0, i);
            string b2 = s2.substr(i);

            string a3 = s2.substr(0, s2.size() - i);
            string b3 = s2.substr(s2.size() - i);

            if(solve(a1, a2) && solve(b1, b2)){
                return dp[key] = true;
            }

            if(solve(a1, b3) && solve(b1, a3)){
                return dp[key] = true;
            }
        }
        return dp[key] = false;
    }
};