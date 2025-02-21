class Solution {
    public int kthGrammar(int n, int k) {
        boolean a = true ;
        n = (int)Math.pow(2,n-1) ;
        while(n!=1){
            n/=2 ;
            if(k>n){
                k-=n ;
                a = !a ;
            }
        }
        return a ? 0 : 1 ;
    }
}