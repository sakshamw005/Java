class Solution {
public:
    bool canPartitionGrid(vector<vector<int>>& grid) {
        long long sum = 0 ;
        int m = grid.size() , n = grid[0].size() ;
        for(int i = 0 ; i<m ; i++)for(int j = 0 ; j<n ; j++)sum+=grid[i][j] ;
        if(sum%2!=0)return false ;
        long long rowsum = 0 , colsum = 0 ;
        for(int i = 0 ; i<m ; i++){
            for(int j = 0 ; j<n ; j++){
                rowsum += grid[i][j] ;
                if(rowsum*2==sum && j == n-1)return true ;
            }
        }
        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<m ; j++){
                colsum += grid[j][i] ;
                if(colsum*2==sum && j == m-1)return true ;
            }
        }
        return false ;
    }
};