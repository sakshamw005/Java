class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length , min = 1 , ma = Integer.MIN_VALUE ;
        for(int i : piles)ma = Math.max(i,ma) ;
        int ans = ma ;
        while(min<=ma){
            int mid = min + (ma-min)/2 ;
            long hours = 0 ;
            for(int i : piles){
                hours+=(i+mid-1)/mid ;
            }
            if(hours<=h){
                ans = mid ;
                ma = mid - 1 ;
            }
            else{
                min = mid + 1 ;
            }
        }
        return ans ;
    }
}