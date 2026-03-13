class Solution {
    public int maximumStrongPairXor(int[] nums) {
        int ans = 0 ;
        for(int i = 0 ; i<nums.length-1 ; i++){
            for(int j = i+1 ; j<nums.length ; j++){
                int x = nums[i] , y = nums[j] ;
                if(Math.abs(x-y) <= Math.min(x,y)){
                    ans = Math.max(ans,x^y) ;
                }
            }
        }
        return ans ;
    }
}