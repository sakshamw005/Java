class Solution {
    public int tupleSameProduct(int[] nums) {
        if(nums.length<4)return 0 ;
        // 2 3 4 6
        Map<Integer,Integer> map = new HashMap<>() ;
        for(int i = 0 ; i<nums.length-1 ; i++){
            int var = nums[i] ;
            for(int j = i+1 ; j<nums.length ; j++){
                if(nums[j]!=var){
                    var*=nums[j] ;
                    map.put(var,map.getOrDefault(var,0)+1) ;
                    var/=nums[j] ;
                }
            }
        }
        //System.out.println(map) ;
        int ans = 0 ;
        for(int i : map.values()){
            if(i>1){
                ans+=i*(i-1)*4 ;
            }
        }
        return ans ;
    }
}