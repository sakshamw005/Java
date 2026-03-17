class Solution {
    static char[] arr = {'a','e','i','o','u'} ;
    public int countVowelStrings(int n) {
        return solve(0,n) ;
    }
    public int solve(int st , int n){
        if(n==0)return 1 ;
        int ans = 0 ;
        for(int i = st ; i<5 ; i++){
            ans += solve(i,n-1) ;
        }
        return ans ;
    }
}