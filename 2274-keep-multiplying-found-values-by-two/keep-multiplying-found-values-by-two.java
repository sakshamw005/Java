class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> s = new HashSet<>() ;
        for(int i : nums)s.add(i) ;
        while(s.contains(original)){
            original*=2 ;
        }
        return original ;
    }
}