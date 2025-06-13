class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums) ;
        int n = nums.length , left = 0 , right = nums[n-1] - nums[0] ;
        while(left<right){
            int mid = left + (right-left)/2 ;
            if(possible(nums,p,mid)){
                right = mid ;
            }
            else{
                left = mid+1 ;
            }
        }
        return left ; 
    }
    private boolean possible(int[] nums , int p , int mid){
        int x = 0 ;
        for(int i = 1 ; i<nums.length ; i++){
            if(nums[i]-nums[i-1]<=mid){
                x++ ;
                i++ ;
            }
        }
        return x >= p ;
    }
}