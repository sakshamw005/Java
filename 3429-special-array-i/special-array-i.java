class Solution {
    public boolean isArraySpecial(int[] nums) {
        if(nums.length==1){
            return true ;
        }
        for(int i = 0 ; i<nums.length-1 ; i++){
            if(parity(nums[i])==parity(nums[i+1])){
                return false ;
            }
        }
        return true ;
    }
    public static int parity(int n){
        return n%2 ;
    }
}