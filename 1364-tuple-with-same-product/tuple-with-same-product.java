class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer,Integer> m = new HashMap<>() ;
        for(int i = 0 ; i<nums.length ; i++){
            for(int j = i+1 ; j<nums.length ; j++){
                int prod = nums[i]*nums[j] ;
                if(!m.containsKey(prod)){
                    m.put(prod,1) ;
                }
                else{
                    m.put(prod,m.get(prod)+1) ;
                }
            }
        }
        int ans = 0;
        for (int count : m.values()) {
            if(count > 1) {
                ans += count *(count - 1) * 4; 
            }
        }
        return ans;
    }
}