class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer,Integer> map = new HashMap<>() ;
        for(int i = 0 ; i<nums.length ; i++){
            map.put(nums[i],i) ;
        }
        for(int[] i : operations){
            int l = i[0] , r = i[1] ;
            int idx = map.get(l) ;
            nums[idx] = r ;
            map.put(r,idx) ;
        }
        return nums ;
    }
}