class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>() ;
        for(int i : nums)map.put(i,map.getOrDefault(i,0)+1) ;
        int m = 1 ;
        for(int i : map.values()) {
            if(i>m){
                m = i ;
            }
        }
        int ans = 0 ;
        for(int i : map.values()){
            if(i==m)ans+=i ;
        }
        return ans ;
    }
}