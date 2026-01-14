class Solution {
    public int[] singleNumber(int[] nums) {
        return Single_Number_III(nums) ;
    }
    private int[] Single_Number_III(int[] arr){
        int xor = 0 ;
        for(int i : arr)xor^=i ;
        int mask = (xor&(-1*xor)) ; //(xor&(xor-1))
        int a = 0 ;
        for(int i = 0 ; i<arr.length ; i++){
            if((mask & arr[i]) != 0){
                a = a ^ arr[i] ;
            }
        }
        int b = xor ^ a ;
        return new int[]{a,b} ;
    }
}
