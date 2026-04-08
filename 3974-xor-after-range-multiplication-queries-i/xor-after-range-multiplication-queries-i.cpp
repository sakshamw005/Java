class Solution {
public:
    int mod = 1e9 + 7 ;
    int xorAfterQueries(vector<int>& nums, vector<vector<int>>& queries) {
        for(int i = 0 ; i<queries.size() ; i++){
            int idx = queries[i][0] , r = queries[i][1] , k = queries[i][2] , v = queries[i][3] ;
            while(idx <= r){
                nums[idx] = (1LL * nums[idx] * v) % mod;
                idx += k ;
            }
        }
        int ans = 0 ;
        for(int i : nums){
            ans ^= i ;
        }
        return ans ;
    }
};