class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0 , sum2 = 0;
        long zeroc1 = 0 , zeroc2 = 0 ;
        for(int i : nums1){
            sum1+=i ;
            if(i==0){
                zeroc1++ ;
                sum1++ ;
            }
        }
        for(int i : nums2){
            sum2+=i ;
            if(i==0){
                zeroc2++ ;
                sum2++ ;
            }
        }
        if(((zeroc1==0 && sum1<sum2 )|| (zeroc2==0 && sum2<sum1))){
            return -1 ;
        }
        return Math.max(sum1,sum2) ;
    }
}