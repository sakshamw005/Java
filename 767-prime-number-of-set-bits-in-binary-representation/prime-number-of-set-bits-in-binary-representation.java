class Solution {
    public int countPrimeSetBits(int left, int right) {
        Set<Integer> set = new HashSet<>() ;
        int ans = 0 ;
        for(int i = left ; i<=right ; i++){
            int x = Integer.bitCount(i) ;
            if(set.contains(x) || isPrime(x)){
                set.add(x) ;
                ans++ ;
            }
        }
        return ans ;
    }
    public boolean isPrime(int n){
        if(n<2)return false ;
        for(int i = 2 ; i*i<=n ; i++){
            if(n%i==0)return false ;
        }
        return true ;
    }
}