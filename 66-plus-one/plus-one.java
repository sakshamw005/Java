class Solution {
    public int[] plusOne(int[] digits) {
        int a = 0 ;
        for(int i = digits.length-1 ; i>=0 ; i--){
            a = a + digits[i] ;
            if(i==digits.length-1){
                a+=1 ;
            }
            digits[i] = a%10 ;
            a/=10 ;
        }
        if(a!=0){
            int[] ans = new int[digits.length+1] ;
            ans[0] = a ;
            for(int i = 1 ; i<ans.length ; i++){
                ans[i] = digits[i-1] ;
            }
            return ans ;
        }
        else{
            return digits ;
        }
    }
}