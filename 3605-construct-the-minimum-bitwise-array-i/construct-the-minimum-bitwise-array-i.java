class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];
        Arrays.fill(ans, -1);
        for(int i = 0 ; i<nums.size() ; i++){
            if(nums.get(i)%2!=0){
                for(int j = 1 ; j<=nums.get(i) ; j++){
                    if(nums.get(i)==(j|(j+1))){
                        ans[i] = j ;
                        break ;
                    }
                }
            }
        }
        return ans; 
    }
}