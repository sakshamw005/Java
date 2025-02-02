class Solution {
    public boolean check(int[] nums) {
        int x = 0 ;
        for(int i = 0 ; i<nums.length ; i++){
            if(nums[i]>nums[(i+1)%nums.length]){
                x++ ;
            }
        }
        return x==0 || x==1 ? true : false ;
    }
}