class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for(int i = 0 ; i<=60 ; i++){
            long tot_sum = (long) num1 - (long)i*num2 ;
            if(tot_sum<0)continue ;
            if(tot_sum<i)continue ;
            int ones = Long.bitCount(tot_sum) ;
            if(ones<=i){
                return i;
            }
        }
        return -1 ;
    }
}