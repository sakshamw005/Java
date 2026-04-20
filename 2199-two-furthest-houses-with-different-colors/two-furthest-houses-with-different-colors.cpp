class Solution {
public:
    int maxDistance(vector<int>& colors) {
        int ans = 0 , n = colors.size() ;
        for(int i = n-1 ; i>=0 ; i--){
            if(colors[i]!=colors[0]){
                ans = max(ans,i); 
            }
        }
        for(int i = 0 ; i<n; i++){
            if(colors[i]!=colors[n-1]){
                ans = max(ans, n-1-i); 
            }
        }
        return ans ;
    }
};