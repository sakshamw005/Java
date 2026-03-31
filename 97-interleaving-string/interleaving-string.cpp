class Solution {
public:
    bool isInterleave(string s1, string s2, string s3) {
        vector<vector<vector<int>>> dp(s1.size(),vector<vector<int>>(s2.size(),vector<int>(s3.size() , -1)));
        return solve(s1,s2,s3,0,0,0,dp) ;
    }
    bool solve(string s1, string s2, string s3 , int i , int j , int k , vector<vector<vector<int>>> &dp){
        if(k==s3.length()){
            if(i==s1.length() && j==s2.length())return true ;
            return false ;
        }
        if(i < s1.size() && j < s2.size() && dp[i][j][k] != -1){
            return dp[i][j][k];
        }
        bool ans = false ;
        if(i < s1.length() && s3[k] == s1[i]){
            ans |= solve(s1,s2,s3,i+1,j,k+1,dp);
        }

        if(j < s2.length() && s3[k] == s2[j]){
            ans |= solve(s1,s2,s3,i,j+1,k+1,dp);
        }
        if(i < s1.size() && j < s2.size()){
            dp[i][j][k] = ans;
        }
        return ans ;
    }
};