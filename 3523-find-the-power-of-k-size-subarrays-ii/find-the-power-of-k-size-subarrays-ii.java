class Solution {
    public int[] resultsArray(int[] nums, int k) {
        if(k==1)return nums ;
        int n = nums.length ;
        if(n==1)return new int[]{nums[0]} ;
        int[] ans = new int[n-k+1] ;
        int x = 1 ;
        for(int i = 1 ; i<n ; i++){
            if(nums[i]==nums[i-1]+1){
                x++ ;
            }
            else{
                x = 1 ;
            }
            if(i>=k-1){
                if(x>=k){
                    ans[i-k+1] = nums[i] ;
                }
                else{
                    ans[i-k+1] = -1 ;
                }
            }
        }
        return ans ;
    }
}