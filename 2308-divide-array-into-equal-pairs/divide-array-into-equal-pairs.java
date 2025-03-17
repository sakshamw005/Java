class Solution {
    public boolean divideArray(int[] nums) {
        Map<Integer,Integer> m = new HashMap<>() ;
        for(int i : nums){
            m.put(i , m.getOrDefault(i,0)+1) ;
        }
        for(int i : m.values()){
            if(i%2!=0)return false ;
        }
        return true ;
    }
}