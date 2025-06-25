class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int ans = 0 ;
        int curr = 0 ;
        while(curr<target || (curr-target)%2!=0){
            ans++ ;
            curr+=ans ;
        }
        return ans ;
    }
}