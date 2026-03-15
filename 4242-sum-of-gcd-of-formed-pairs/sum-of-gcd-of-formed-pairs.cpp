class Solution {
public:
    long long gcdSum(vector<int>& nums) {
        vector<int> mx(nums.size()) ;
        stack<int> st ;
        st.push(0) ;
        mx[0] = nums[0] ;
        for(int i = 1 ; i<nums.size() ; i++){
            mx[i] = max(nums[i],mx[i-1]) ;
        }
        vector<int> prefixGCD(nums.size()) ;
        for(int i = 0 ; i<nums.size() ; i++){
            prefixGCD[i] = gcd(nums[i],mx[i]) ;
        }
        sort(prefixGCD.begin(),prefixGCD.end()) ;
        int l = 0 , r = nums.size() - 1 ;
        long long ans = 0 ;
        while(l<r){
            ans += gcd(prefixGCD[l],prefixGCD[r]) ;
            l++ ;
            r-- ;
        }
        return ans ;
    }
    int gcd(int a , int b){
        if(b==0)return a ;
        return gcd(b,a%b) ;
    }
};