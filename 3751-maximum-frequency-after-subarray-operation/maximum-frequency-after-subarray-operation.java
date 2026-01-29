class Solution {
    public int maxFrequency(int[] nums, int k) {
        // Map<Integer,Integer> map = new HashMap<>() ;
        // for(int i : nums)map.put(i,map.getOrDefault(i,0)+1) ;
        // int ans = 1 ;
        // for(int i : map.values())ans=Math.max(ans,i) ;
        // return map.getOrDefault(k,0) + ans ;
        int ans = 0 ;
        for(int i : nums)if(i==k)ans++ ;
        int base = ans ;
        for(int i = 1 ; i<=50 ; i++){
            if(i==k)continue ;
            int a = 0 , b = 0 ;
            for(int j : nums){
                if(j==i)b++ ;
                else if(j==k)b-- ;
                if(b<0)b=0 ;
                a = Math.max(a,b) ;
            }
            ans = Math.max(ans,a+base) ;
        }
        return ans ;
    }
}