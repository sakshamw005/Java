class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans = 0 ;
        for(int i : nums){
            int c = 2  , ax = i+1 ;
            for(int j = 2 ; j*j<=i ; j++){
                if(i%j==0){
                    c++ ;
                    ax+=j ;
                    if(j!=i/j){
                        c++ ;
                        ax+= i/j ;
                    }
                    if(c>4) break ;
                }
            // System.out.println(ax) ;
            }
            if(c==4){
                ans+=ax ;
            }
        }
        return ans ;
    }
}