class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] ans = new int[A.length] ;
        int[] count = new int[A.length+1] ;
        int c = 0 ;
        for(int i = 0 ; i<A.length ; i++){
            count[A[i]]++ ;
            count[B[i]]++ ;
            if(count[A[i]]==2){
                c+=1 ;
            }
            if(A[i] != B[i] && count[B[i]]==2){
                c+=1 ;
            }
            ans[i] = c ;
        }
        return ans ;
    }
}