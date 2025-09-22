class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>() ;
        boolean[] used = new boolean[nums.length] ;
        print(nums, new ArrayList<>() , ans, used) ;
        return ans ;
    }
    public static void print(int[] nums , List<Integer> temp , List<List<Integer>> ans , boolean[] used){
        if(temp.size() == nums.length){
            ans.add(new ArrayList<>(temp)) ;
            return ;
        }
        for(int i = 0 ; i<nums.length ; i++){
            if(!used[i]){
                temp.add(nums[i]) ;
                used[i] = true ;
                print(nums,temp,ans,used) ;
                temp.remove(temp.size()-1) ;
                used[i] = false ;
            }
        }
    }
}