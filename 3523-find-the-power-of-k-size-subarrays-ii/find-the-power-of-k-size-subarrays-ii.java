class Solution {
    public int[] resultsArray(int[] nums, int k) {
        if (k == 1) return nums;
        if(nums.length==1){
            return new int[]{nums[0]} ;
        }
        if(nums.length==1)return new int[]{-1} ;
        int[] ans = new int[nums.length-k+1] ;
        Arrays.fill(ans,-1) ;
        int x = 1 ;
        int idx = 0 ;
        for(int i = 1 ; i<nums.length ; i++){
            if(nums[i-1]+1==nums[i]){
                x++ ;
            }
            else{
                x = 1 ;
            }
            if(x>=k){
                ans[i-k+1] = nums[i] ;
                x-- ;
            }
        }
        return ans ;
    }
}