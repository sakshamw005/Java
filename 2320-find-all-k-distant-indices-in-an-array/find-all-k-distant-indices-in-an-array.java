class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> ans = new ArrayList<>() ;
        int n = nums.length ;
        for(int i = 0 ; i<n ; i++){
            for (int j = Math.max(0, i - k); j <= Math.min(n - 1, i + k); j++) {
                if(j<n && nums[j]==key){
                    ans.add(i) ;
                    break ;
                }
            }
        }
        return ans ;
    }
}