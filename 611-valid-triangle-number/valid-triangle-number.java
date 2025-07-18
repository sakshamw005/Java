class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums) ;
        int ans = 0 ;
        for(int k = nums.length-1 ; k>=0 ; k--){
            int i = 0 , j = k-1 , to = nums[k];
            while(i<j){
                if(nums[i]+nums[j]>to){
                    ans+=(j-i) ;
                    j-- ;
                }
                else{
                    i++ ;
                }
            }
        }
        return ans ;
    }
}