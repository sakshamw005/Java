class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> l = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            HashMap<Integer,Integer> m = new HashMap<>() ;
            for (int j = i + 1; j < nums.length; j++) {
                int temp = -(nums[i]+nums[j]) ;
                if(m.containsKey(temp)){
                    ArrayList<Integer> x = new ArrayList<>(Arrays.asList(nums[i],nums[j],temp)) ;
                    Collections.sort(x) ;
                    set.add(x) ;
                }
                m.put(nums[j],j) ;
            }
        }
        l.addAll(set) ;
        return l ;
    }
}