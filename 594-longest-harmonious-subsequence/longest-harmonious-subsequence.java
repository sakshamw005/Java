class Solution {
    public int findLHS(int[] nums) {
        Map<Integer,Integer> m = new HashMap<>() ;
        for(int i : nums)m.put(i,m.getOrDefault(i,0)+1);
        int ans = 0 ;
        for(int i : m.keySet())if(m.containsKey(i+1))ans = Math.max(ans,m.get(i)+m.get(i+1)) ;
        return ans ;
    }
}