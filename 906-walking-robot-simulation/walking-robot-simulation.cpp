class Solution {
public:
    int robotSim(vector<int>& commands, vector<vector<int>>& obstacles) {
        set<pair<int,int>> obs ;
        for(auto &i : obstacles){
            obs.insert({i[0],i[1]}) ;
        }
        vector<pair<int,int>> dirs = {{0,1},{1,0},{0,-1},{-1,0}} ;
        int d = 0 , x = 0 , y = 0 , ans = 0 ;
        for(int i : commands){
            if(i==-2){
                d = (d+3)%4 ;
            }
            else if(i==-1){
                d = (d+1)%4 ;
            }
            else{
                for(int j = 0 ; j < i ; j++){
                    int nx = x + dirs[d].first , ny = y + dirs[d].second ;
                    if(obs.count({nx,ny}))break ;
                    x = nx ;
                    y = ny ;
                    ans = max(ans , x*x + y*y) ;
                }
            }
        }
        return ans ;
    }
};
// 0 N , 1 E , 2 S , 3 W