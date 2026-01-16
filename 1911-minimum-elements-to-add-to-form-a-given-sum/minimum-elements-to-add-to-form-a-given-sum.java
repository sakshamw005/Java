class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0 ;
        for(int i : nums)sum+=i ;
        if(sum==goal)return 0 ;
        long reqd = Math.abs(goal - sum) ;
        if(Math.abs(reqd)<=limit)return 1 ;
        return (int)((reqd + limit - 1) / limit);
    }
}