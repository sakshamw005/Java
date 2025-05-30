class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>() ;
        Set<List<Integer>> temp = new HashSet<>() ;
        List<Integer> l = new ArrayList<>() ;
        Arrays.sort(nums) ;
        print(nums,0,l,temp) ;
        ans.addAll(temp);
        return ans ;
    }
    public static void print(int[] nums,int curr ,List<Integer> l ,Set<List<Integer>> temp ){
        if (curr == nums.length) {
            temp.add(new ArrayList<>(l)); 
            return;
        }
        l.add(nums[curr]) ;
        print(nums,curr+1,l,temp) ;
        l.remove(l.size()-1) ;
        print(nums, curr + 1, l, temp);
    }
}