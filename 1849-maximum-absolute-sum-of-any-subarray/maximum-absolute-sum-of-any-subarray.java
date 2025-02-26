class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max = nums[0] , min = nums[0] ;
        int currma = 0 , currmi = 0;
        for(int i : nums){
            currma += i;
            max = Math.max(max , currma) ;
            if(currma<0)currma=0;
        }
        for(int i : nums){
            currmi += i;
            min = Math.min(min , currmi) ;
            if(currmi>0)currmi=0;
        }
        return Math.max(Math.abs(max),Math.abs(min)) ;
    }
}