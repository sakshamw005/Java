class Solution {
    int shifts = 0 ;
    public char kthCharacter(long k, int[] operations) {
        long len = 1;
        int n = 0;
        while (n < operations.length && len < k) {
            if (operations[n] == 0) len *= 2;
            else len += len;
            n++;
        }
        for(int i = n-1 ; i>=0 ; i--){
            int curr = operations[i] ;
            len/=2 ;
            if(curr==0){
                if(k>len){
                    k-=len ;
                }
            }
            else{
                if(k>len){
                    k-=len ;
                    shifts++ ;
                }
            }
        }
        return (char)((('a'-'a'+shifts)%26)+'a') ;
    }
}