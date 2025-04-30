class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> l = new ArrayList<>() ;
        for(int i = 0 ; i<nums.length ; i++){
            if(l.isEmpty() || nums[i]>l.get(l.size()-1)){
                l.add(nums[i]) ;
            }
            else{
                int n = search(l,nums[i]) ;
                l.set(n,nums[i]) ;
            }
        }
        return l.size() ;
    }
    public int search(List<Integer> l , int target){
        int i = 0 , j = l.size()-1 ;
        while(i<=j){
            int mid = (i+j)/2 ;
            if(l.get(mid)==target){
                return mid ;
            }
            if(l.get(mid)>target){
                j = mid - 1 ; ;
            }
            else{
                i = mid+1 ;
            }
        }
        return i ;
    }
}