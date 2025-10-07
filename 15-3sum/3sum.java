class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>() ;
        Set<List<Integer>> s = new HashSet<>() ;

        for(int i = 0 ; i < nums.length ; i++){
            Map<Integer,Integer> map = new HashMap<>() ;
            for(int j = i+1 ; j<nums.length ; j++){
                int key = -(nums[i]+nums[j]) ;
                if(map.containsKey(key)){
                    List<Integer> ll = new ArrayList<>(Arrays.asList(nums[i],nums[j],key)) ;
                    Collections.sort(ll) ;
                    s.add(ll) ;
                }
                map.put(nums[j],j) ;
            }
        }
        ans.addAll(s) ;
        return ans ;
    }
}