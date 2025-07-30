class Solution {
    public int longestSubarray(int[] nums) {
        int mx = 0 ;
        for(int i : nums){
            mx = Math.max(i,mx) ;
        }
        int curr = 0 , ma = 0 ;
        for(int i : nums){
            if(i==mx){
                curr++ ;
                ma = Math.max(ma,curr) ;
            }
            else{
                curr = 0 ;
            }
        }
        return ma ;
    }
}