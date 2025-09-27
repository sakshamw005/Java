class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1)return 0 ;
        for(int i = 0 ; i<nums.length; i++){
            if(check(nums,i)){
                return i ;
            }
        }
        return -1;
    }
    public boolean check(int[] nums , int i){
        boolean l = false , r = false ;
        if(i==0){
            l = true ;
            if(nums[i+1]<nums[i]){
                r = true ;
                return true;
            }
        }
        else if(i==nums.length-1){
            r = true ;
            if(nums[i-1]<nums[i]){
                l = true ;
                return true ;
            }
        }
        else{
            if((nums[i-1]<nums[i]) && (nums[i+1]<nums[i])){
                l = true ;
                r = true ;
            }
        }
        return l&r ;
    }
}