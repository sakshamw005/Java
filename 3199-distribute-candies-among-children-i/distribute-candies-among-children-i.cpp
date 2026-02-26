class Solution {
public:
    int distributeCandies(int n, int limit) {
        int ans = 0 ;
        for(int i = 0 ; i<=limit ; i++)for(int j = 0 ; j<=limit ; j++){
            int idx = n - i - j ;
            if(idx<=limit && idx>=0)ans++ ;
        }
        return ans ;
    }
};