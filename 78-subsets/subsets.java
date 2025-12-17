class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>() ;
        print(nums,0,ans,new ArrayList<Integer>()) ;
        return ans ;
    }
    public void print(int[] nums , int i , List<List<Integer>> ans , List<Integer> l){
        if(i==nums.length){
            ans.add(new ArrayList<>(l)) ;
            return ;
        }
        print(nums,i+1,ans,l) ;
        l.add(nums[i]) ;
        print(nums,i+1,ans,l) ;
        l.remove(l.size()-1) ;
    }
}