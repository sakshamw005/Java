class Solution {
public:
    int compareBitonicSums(vector<int>& nums) {
        int n = nums.size();

        vector<bool> inc(n, false), dec(n, false);

        inc[0] = true;
        for(int i = 1; i < n; i++){
            if(nums[i] > nums[i-1] && inc[i-1]) inc[i] = true;
        }

        dec[n-1] = true;
        for(int i = n-2; i >= 0; i--){
            if(nums[i] > nums[i+1] && dec[i+1]) dec[i] = true;
        }

        int peak = -1;
        for(int i = 0; i < n; i++){
            if(inc[i] && dec[i]){
                peak = i;
                break;
            }
        }

        if(peak == -1) return -1;

        vector<long long> pref(n);
        pref[0] = nums[0];
        for(int i = 1; i < n; i++){
            pref[i] = pref[i-1] + nums[i];
        }

        long long lsum = pref[peak];
        long long rsum = pref[n-1] - (peak > 0 ? pref[peak-1] : 0);

        if(lsum > rsum) return 0;
        else if(rsum > lsum) return 1;
        else return -1;
    }
};