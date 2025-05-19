class Solution {
     private boolean isTriangle(int[] nums) {
        return nums[0] + nums[1] > nums[2] &&
               nums[0] + nums[2] > nums[1] &&
               nums[1] + nums[2] > nums[0];
    }
    public String triangleType(int[] nums) {
        if (!isTriangle(nums)) return "none";
        Map<Integer,Integer> m = new HashMap<>() ;
        for(int i = 0 ; i<nums.length ; i++){
            m.put(nums[i],m.getOrDefault(nums[i],0)+1) ;
        }
        for(int i : m.values()){
            if(i==2){
                return "isosceles" ;
            }
            if(i==3){
                return "equilateral" ;
            }
        }
        return "scalene" ;
    }
}