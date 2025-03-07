class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] prime = new boolean[right+1] ;
        Arrays.fill(prime,true) ;
        prime[0] = prime[1] = false ;
        for(int i = 2 ; i*i<=right ; i++){
            if(prime[i]){
                for(int j = i*i ; j<=right ; j=j+i){
                    prime[j] = false ;
                }
            }
        }
        List<Integer> l = new ArrayList<>() ;
        for (int i = left; i <= right; i++) {
            if (prime[i]) {
                l.add(i);
            }
        }
        int[] ans = {-1,-1} ;
        int minDiff = Integer.MAX_VALUE ;
        for(int i = 1 ; i<l.size() ; i++){
            int diff = l.get(i) - l.get(i-1) ;
            if(diff<minDiff){
                minDiff = diff ;
                ans[0] = l.get(i-1) ;
                ans[1] = l.get(i) ;
            }
        }
        return ans ;
    }
}