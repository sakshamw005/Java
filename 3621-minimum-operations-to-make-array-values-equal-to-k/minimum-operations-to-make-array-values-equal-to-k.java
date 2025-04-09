class Solution {
    public int minOperations(int[] nums, int k) {
        HashMap<Integer,Integer> h = new HashMap<>() ;
        for(int i : nums){
            if(i<k){
                return -1 ;
            }
            else if(i>k){
                h.put(i,h.getOrDefault(i,0)+1) ;
            }
        }
        return h.size() ;
    }
}