class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums) ;
        List<List<Integer>> ans = new ArrayList<>() ;
        Set<List<Integer>> set = new HashSet<>() ;
        for(int i = 0 ; i<nums.length ; i++){
            Map<Integer,Integer> map = new HashMap<>() ;
            for(int j = i+1 ; j<nums.length ; j++){
                int reqd = -(nums[i]+nums[j]) ;
                if(map.containsKey(reqd)){
                    ArrayList<Integer> a = new ArrayList<>(Arrays.asList(nums[i],nums[j],reqd)) ;
                    Collections.sort(a) ;
                    set.add(a) ;
                }
                map.put(nums[j],j) ;
            }
        }
        ans.addAll(set) ;
        return ans ;
    }
}