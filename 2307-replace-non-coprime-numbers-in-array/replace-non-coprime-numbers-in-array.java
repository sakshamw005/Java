class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Long> ans = new ArrayList<>() ;
        for(int i = 0 ; i<nums.length ; i++){
            ans.add((long)nums[i]) ;
            while(ans.size()>1){
                long a = ans.get(ans.size()-2) ;
                long b = ans.get(ans.size()-1) ;
                long gcd = gcd(a,b) ;
                if(gcd==1)break ;
                long lcm = a*b/gcd ;
                ans.remove(ans.size()-2) ;
                ans.remove(ans.size()-1) ;
                ans.add(lcm) ;
            }
        }
        List<Integer> l = new ArrayList<>() ;
        for(long x : ans){
            l.add((int)x) ; 
        }
        return l ;
    }
    public long gcd(long a , long b){
        if(b==0){
            return a ;
        }
        return gcd(b,a%b) ;
    }
}