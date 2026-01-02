class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length/2 ;
        Map<Integer,Integer> map = new HashMap<>() ;
        for(int i : nums)map.put(i,map.getOrDefault(i,0)+1) ;
        for(int i : map.keySet())if(map.get(i)==n)return i ;
        return -1 ; 
    }
}