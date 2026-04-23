class Solution {
public:
    bool check(vector<int>& arr){
        sort(arr.begin(),arr.end()) ;
        if(arr.size()<=2)return true ;
        int val = abs(arr[0]-arr[1]) ;
        for(int i = 2 ; i<arr.size() ; i++){
            if(abs(arr[i]-arr[i-1])!=val)return false ;
        }
        return true ;
    }
    vector<bool> checkArithmeticSubarrays(vector<int>& nums, vector<int>& l, vector<int>& r) {
        vector<bool> ans(l.size(),false) ;
        for(int i = 0 ; i<l.size() ; i++){
            vector<int> ar ;
            for(int j = l[i] ; j<=r[i] ; j++)ar.push_back(nums[j]) ;
            if(check(ar))ans[i] = true ;
        }
        return ans ;
    }
};