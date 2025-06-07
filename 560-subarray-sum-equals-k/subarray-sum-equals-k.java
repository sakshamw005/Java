class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> m = new HashMap<>() ;
        m.put(0,1) ;
        int tot = 0 , ans = 0 ;
        for(int i : nums){
            tot+=i ;
            if(m.containsKey(tot-k)){
                ans += m.get(tot-k) ;
            }
            m.put(tot,m.getOrDefault(tot,0)+1) ;
        }
        return ans ;
    }
}