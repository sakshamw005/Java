class Solution {
public:
    long long minimumTotalDistance(vector<int>& robot, vector<vector<int>>& factory) {
        sort(robot.begin(),robot.end()) ;
        sort(factory.begin(),factory.end()); 
        vector<int> hehe ;
        for(int i = 0 ; i<factory.size() ; i++){
            for(int j = 0;j<factory[i][1] ;j++){
                hehe.push_back(factory[i][0]) ;
            }
        }
        vector<vector<long long>> dp (robot.size(),vector<long long>(hehe.size(),-1));
        return solve(0,0,robot,hehe,dp) ;
    }
    long long solve(int i, int j , vector<int>& robot , vector<int>& hehe,vector<vector<long long>> &dp){
        if(i==robot.size())return 0 ;
        if(j==hehe.size())return 1e12 ;
        if(dp[i][j]!=-1)return dp[i][j] ;
        long long take = abs(robot[i]-hehe[j]) + solve(i+1,j+1,robot,hehe,dp) ;
        long long ntak = solve(i,j+1,robot,hehe,dp) ;
        return dp[i][j] = min(take,ntak) ;
    }
};