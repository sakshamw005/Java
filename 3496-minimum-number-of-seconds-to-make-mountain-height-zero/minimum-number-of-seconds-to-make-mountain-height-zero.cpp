class Solution {
public:
    long long minNumberOfSeconds(int mh, vector<int>& wt) {
        long long ans = -1 , l = 0 , r = LLONG_MAX ;
        while(l<=r){
            long mid = l + (r-l)/2 ;
            if(possible(mid,mh,wt)){
                ans = mid ;
                r = mid - 1 ;
            }        
            else{
                l = mid + 1 ;
            }
        }
        return ans ;
    }
    bool possible(long long sec, int mh, vector<int>& wt){

        long long rem = 0;

        for(int i = 0; i < wt.size(); i++){
            long long w = wt[i];
            long long val = (2 * sec) / w;
            long long x = (sqrt((long double)1 + 4.0L * val) - 1) / 2;
            rem += x;
            if(rem >= mh) return true;
        }
        return false;
    }
};