class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] left = new int[rocks.length] ;
        for(int i = 0 ; i<rocks.length ; i++){
            left[i] = capacity[i] - rocks[i] ;
        }
        Arrays.sort(left) ;
        int ans = 0 ;
        for(int i = 0 ; i<rocks.length ; i++){
            if(left[i]==0)ans++ ;
            if(additionalRocks > 0 && left[i]<=additionalRocks && left[i]>0){
                ans++ ;
                additionalRocks-=left[i] ;
            }
        }
        return ans ;
    }
}