class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer,Integer> m = new HashMap<>() ;
        for(int i : nums){
            m.put(i,m.getOrDefault(i,0)+1) ;
        }
        List<Integer> ans = new ArrayList<>() ;
        for (int key : m.keySet()) {
            if (m.get(key) > 1) {
                ans.add(key);
            }
        }
        return ans ;
    }
}