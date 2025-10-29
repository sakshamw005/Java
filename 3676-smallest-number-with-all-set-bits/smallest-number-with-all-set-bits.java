class Solution {
    public int smallestNumber(int n) {
        if(n==1){
            return 1 ;
        }
        int ans = 0 ;
        for(int i = 0 ; i<n ; i++){
            if(n + 1 <=Math.pow(2,i)){
                ans = i ;
                break ;
            }
        }
        return (int)Math.pow(2,ans) - 1 ;
    }
}