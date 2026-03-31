class Solution {
public:
    vector<int> dp ;
    int numDecodings(string s) {
        dp.resize(s.size(),-1) ;
        return solve(s,0) ;
    }
    int solve(string s , int i){
        if(i==s.size()){
            return 1 ;
        }
        if(s[i]=='0'){
            return 0 ;
        }
        if(dp[i]!=-1){
            return dp[i] ;
        }
        int ans = solve(s,i+1) ;
        if(i+1 < s.length()){
            int num = (s[i] - '0')*10 + (s[i+1]-'0') ;
            if(num >= 10 && num < 27){
                ans += solve(s,i+2) ;
            }
        }
        return dp[i] = ans ;
    }
};